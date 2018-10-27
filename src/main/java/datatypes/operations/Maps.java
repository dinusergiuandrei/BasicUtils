package datatypes.operations;

import java.util.LinkedHashMap;
import java.util.Map;

public class Maps {
    public static Map<Object, Object> generalizeMap(Map<String, String> map){
        Map<Object, Object> newMap = new LinkedHashMap<>();
        map.forEach(newMap::put);
        return newMap;
    }

    public static void displayMap(Map<Object, Object> map, String separator){
        map.forEach((k, v) -> System.out.println(k.toString() + separator + v.toString()));
    }
}
