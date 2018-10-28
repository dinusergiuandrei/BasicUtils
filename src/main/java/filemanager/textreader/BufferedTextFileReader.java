package filemanager.textreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BufferedTextFileReader extends TextFileReader {

    public void read(String sourceFilePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                this.lines.add(line);
                line = br.readLine();
            }

            this.text = sb.toString();
        }
    }

    @Override
    public List<String> getFileAsListOfStrings() {
        return this.lines;
    }

    @Override
    public String getFileAsString() {
        return this.text;
    }
}
