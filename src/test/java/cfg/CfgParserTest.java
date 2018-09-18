package cfg;

import cfg.parser.CfgParser;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CfgParserTest {
    CfgParser parser = new CfgParser();
    Pair<String, String> pair;


    @Test
    public void parseLineTest() throws IOException {

        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<String> separators = new ArrayList<>();

        keys.add("123");
        keys.add("gfsdg");
        keys.add("df4f531+--++++23e!~");
        keys.add("asdfghjkl        \t*-;");

        values.add("/*-+......");
        values.add("AaaaAAAaaAAA");
        values.add("aoisfn asdfiondasf podsisfd asign asfigi");
        values.add(".");

        separators.add("=");
        separators.add("=");
        separators.add("=");
        separators.add("=");

        for (int index = 0; index < keys.size(); index++) {
            String line = keys.get(index) + separators.get(index) + values.get(index);
            pair = parser.parseLine(line, separators.get(index));
            Assert.assertEquals(keys.get(index), pair.getKey());
            Assert.assertEquals(values.get(index), pair.getValue());
        }
    }

    @Test
    public void parseComplexLineTest() throws IOException {
        String line = "\"asd\"='12===3'";
        pair = parser.parseLine(line, "=");
        Assert.assertEquals("asd", pair.getKey());
        Assert.assertEquals("12===3", pair.getValue());
    }

    @Test
    public void parseTextTest() {
        String text = "abc='123'\n" +
                "sg=1523\n" +
                "gaet5r='gsfdg43'\n" +
                "\"hter\"=43fgf\n";
        Map<String, String> map = parser.parse(text, "=");
        Assert.assertEquals("123", map.get("abc"));
        Assert.assertEquals("1523", map.get("sg"));
        Assert.assertEquals("gsfdg43", map.get("gaet5r"));
        Assert.assertEquals("43fgf", map.get("hter"));
    }
}
