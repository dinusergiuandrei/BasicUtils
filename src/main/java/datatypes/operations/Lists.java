package datatypes.operations;

import java.util.List;

public class Lists {
    public static String toString(List<Object> list, String separator, String startToken, String endToken) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startToken);
        for (int index = 0; index < list.size(); index++) {
            stringBuilder.append(list.get(index));
            if (index < list.size() - 1)
                stringBuilder.append(separator);
        }
        stringBuilder.append(endToken);
        return stringBuilder.toString();
    }
}
