package filemanager.textwriter;

import java.io.*;

public class BufferedTextFileWriter extends TextFileWriter{
    @Override
    public void overwriteTextToFile(String path, String text) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void appendTextToFile(String path, String text) {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))) {
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
