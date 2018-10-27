package datatypes.operations;

import java.util.Set;

public class Sets {
    public static String toString(Set<Object> set, String separator, String startToken, String endToken) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startToken);

        set.forEach(e -> stringBuilder.append(e.toString()).append(separator));

        stringBuilder.append(endToken);
        return stringBuilder.toString();
    }
}
