package cfg.writer;

import filemanager.FileManager;

import java.io.IOException;
import java.util.Map;

public class CfgWriter {
    public void writeMapToFile(String filePath, Map<Object, Object> map, String separator) throws IOException {
        FileManager.createFile(filePath);
        StringBuilder builder = new StringBuilder();
        map.forEach(
                (k, v) -> {
                    String line = k.toString() + separator + v.toString();
                    builder.append(line).append("\n");
                }
        );
        FileManager.writeTextToFile(filePath, builder.toString());
    }
}
