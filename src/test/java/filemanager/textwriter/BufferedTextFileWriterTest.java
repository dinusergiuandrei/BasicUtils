package filemanager.textwriter;

import org.junit.Before;
import org.junit.Test;

public class BufferedTextFileWriterTest {

    private String text;
    private String path;
    private TextFileWriter writer;

    @Before
    public void setUp(){
        text = "some text to test the writer";
        path = "data/files/sample.txt";
        writer = new BufferedTextFileWriter();
    }

    @Test
    public void overwriteTextToFileTest(){
        writer.overwriteTextToFile(path, text);
    }
    @Test
    public void appendTextToFileTest(){
        writer.appendTextToFile(path, text);
    }


}
