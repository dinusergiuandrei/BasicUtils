package datatypes;

import datatypes.operations.Strings;
import filemanager.FileManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringsTest {
    List<String> lines = new ArrayList<>();
    String text;

    @Before
    public void setUp() {
        lines.add("a");
        lines.add("b");
        lines.add("c");
        lines.add("d");
        lines.add("e");
        text = "a\nb\nc\nd\ne\n";
    }

    @Test
    public void stringFromLinesTest() {
        Assert.assertEquals(text, Strings.getStringFromLines(lines, "\n"));
    }

    @Test
    public void linesFromStringTest() {
        Assert.assertEquals(lines, Strings.getLinesFromText(text));
    }

    @Test
    public void classNameExtractionTest() {
        Assert.assertEquals("test", Strings.extractClassNameFromSourcePath("test.java"));
        Assert.assertEquals("test", Strings.extractClassNameFromSourcePath("a/b/c/test.java"));
        Assert.assertEquals("test", Strings.extractClassNameFromSourcePath("/a/b/c/test.java"));
    }
}
