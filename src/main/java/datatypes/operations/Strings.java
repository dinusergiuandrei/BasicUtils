package datatypes.operations;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strings {
    public static String getStringFromLines(List<String> lines){
        StringBuilder builder = new StringBuilder();
        lines.forEach(builder::append);
        return builder.toString();
    }

    public static List<String> getLinesFromText(String text){
        String[] lines = text.split("\n");
        return new ArrayList<>(Arrays.asList(lines));
    }

    public static String extractClassNameFromSourcePath(String sourcePath) {
        if (sourcePath.endsWith(".java")) {
            String classPath = sourcePath.substring(0, sourcePath.length() - 5);

            classPath = classPath.replace('\\', '/');
            String[] nodes = classPath.split("/");
            return nodes[nodes.length - 1];
        } else {
            System.err.println("Source path does not point to a java file: " + sourcePath);
        }
        return null;
    }

    public static String getStringFromInputStream(InputStream ins) throws Exception {
        StringBuilder s = new StringBuilder();
        String line;
        BufferedReader in = new BufferedReader(new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            s.append(line);
            s.append('\n');
        }
        return s.toString();
    }
}
