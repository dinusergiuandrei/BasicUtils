package cfg;

import cfg.parser.CfgParser;
import cfg.writer.CfgWriter;
import datatypes.operations.Maps;
import datatypes.structure.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CfgTest {
    private String path;
    private Map<String, String> realMap = new LinkedHashMap<>();
    private CfgWriter cfgWriter = new CfgWriter();

    private CfgParser parser = new CfgParser();
    private Pair<String, String> pair;

    @Before
    public void setUp() throws IOException {
        path = "testdata/cfg/data1.cfg";

        realMap.put("abc", "123");
        realMap.put("sg", "1523");
        realMap.put("gaet5r", "gsfdg43");
        realMap.put("hter", "43fgf");

        cfgWriter.writeMapToFile(path, Maps.generalizeMap(realMap), "=");
    }

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
    public void parseTextTest() throws IOException {
        String textPath = "testdata/cfg/data1.cfg";
        Map<String, String> parserMap = parser.parseFile(textPath, "=");

        realMap.forEach((k, v) -> Assert.assertEquals(v, parserMap.get(k)));
    }
}
