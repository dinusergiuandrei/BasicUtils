package cfg;

import cfg.writer.CfgWriter;
import datatypes.operations.Maps;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CfgWriterTest {
    private String path;
    private Map<String, String> map;
    private CfgWriter cfgWriter;

    @Before
    public void setUp(){
        cfgWriter = new CfgWriter();
        path = "testdata/cfg/data1.cfg";
        map = new LinkedHashMap<>();

        map.put("abc", "123");
        map.put("sg", "1523");
        map.put("gaet5r", "gsfdg43");
        map.put("hter", "43fgf");
    }

    @Test
    public void writeMapToFileTest() throws IOException {
        cfgWriter.writeMapToFile(path, Maps.generalizeMap(map), "=");
    }
}
