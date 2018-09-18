package filemanager.textwriter;

public abstract class TextFileWriter {
    public abstract void overwriteTextToFile(String path, String text);

    public abstract void appendTextToFile(String path, String text);
}
