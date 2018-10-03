package json;

import datatypes.structure.trees.BasicTree;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class JsonWriterTest {
    private String path = "testdata/json/data.json";
    private JsonWriter writer = new JsonWriter();
    private BasicTree tree;

    @Before
    public void setUp() throws IOException {
        String sourcePath = "testdata/json/data.json";
        JsonParser parser = new JsonParser();
        tree = parser.parse(sourcePath);
    }

    @Test
    public void jsonWriteTest() throws IOException {
        writer.writeJson(path, tree);
    }
}
