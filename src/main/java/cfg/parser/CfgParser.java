package cfg.parser;

import datatypes.operations.strings.Strings;
import filemanager.FileManager;
import javafx.util.Pair;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CfgParser {

    public Pair<String, String> parseLine(String line, String separator) throws IOException {
        line = line.trim();
        Character token = null;
        if (line.startsWith("\""))
            token = '\"';
        if (line.startsWith("'"))
            token = '\'';

        if (token != null) {
            line = line.substring(1);
            int index = line.indexOf(token);
            if (index < 0) {
                throw new IOException("Wrong line format. Please close the " + token);
            }
            String left = line.substring(0, index);
            line = line.substring(index + 1).trim();
            if (!line.startsWith(separator)) {
                throw new IOException("Wrong line format. Separator " + separator + " is not present, or extra characters are before it.");
            }
            String right = line.substring(1).trim();
            if (right.charAt(0) == right.charAt(right.length() - 1) && (right.startsWith("'") || right.endsWith("\"")))
                right = right.substring(1, right.length() - 1);
            return new Pair<>(cleanElement(left), cleanElement(right));
        } else {
            Integer middle = line.indexOf(separator);
            String left = line.substring(0, middle).trim();
            String right = line.substring(middle + 1).trim();
            return new Pair<>(cleanElement(left), cleanElement(right));
        }
    }

    private Map<String, String> parse(String text, String separator) {
        List<String> lines = Strings.getLinesFromText(text);
        Map<String, String> map = new LinkedHashMap<>();
        lines.forEach(line -> {
            if (line != null && line.contains(separator)) {
                try {
                    Pair<String, String> pair = parseLine(line, separator);
                    map.put(pair.getKey(), pair.getValue());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return map;
    }

    public Map<String, String> parseFile(String filePath, String separator) throws IOException {
        return parse(FileManager.getTextFromFile(filePath), separator);
    }

    private String cleanElement(String element) {
        element = element.trim();
        if ((element.startsWith("\"") || element.startsWith("'"))
                && element.charAt(0) == element.charAt(element.length() - 1)) {

            return element.substring(1, element.length() - 1);

        } else return element;
    }
}
