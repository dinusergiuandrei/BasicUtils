package datatypes.operations.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strings {
    public static String getStringFromLines(List<String> lines){
        StringBuilder builder = new StringBuilder();
        lines.forEach(builder::append);
        return builder.toString();
    }

    public static List<String> getLinesFromText(String text){
        String[] lines = text.split("\n");
        return new ArrayList<>(Arrays.asList(lines));
    }
}
