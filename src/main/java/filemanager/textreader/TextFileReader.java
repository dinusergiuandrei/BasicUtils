package filemanager.textreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
 */

public abstract class TextFileReader {

    List<String> lines = new ArrayList<>();

    protected String text;

    abstract public void read(String sourceFilepath) throws IOException;

    public abstract List<String> getFileAsListOfStrings();

    public abstract String getFileAsString();
}
