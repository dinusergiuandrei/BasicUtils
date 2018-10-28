package json;

import datatypes.operations.trees.TreePrinter;
import datatypes.structure.trees.BasicTree;
import org.junit.Test;

import java.io.IOException;

//todo: actually test json parser, not just demo
public class JsonParserTest {
    private String path;
    private JsonParser parser = new JsonParser();

    @Test
    public void parseTest() throws IOException {
        path = "testdata/json/data.json";
        BasicTree tree = parser.parse(path);
        TreePrinter printer = new TreePrinter();
        printer.displayTree(tree);
    }
}
