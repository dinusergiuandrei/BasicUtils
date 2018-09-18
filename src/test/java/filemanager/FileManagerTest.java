package filemanager;

import org.junit.Test;

import java.io.IOException;

public class FileManagerTest {
    @Test
    public void createFileTest() throws IOException {
        FileManager.createFile("data/files/sample1.txt");
    }
}
