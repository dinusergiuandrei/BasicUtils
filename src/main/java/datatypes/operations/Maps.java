package datatypes.operations;

import java.util.LinkedHashMap;
import java.util.Map;

public class Maps {
    public static Map<Object, Object> generalizeMap(Map<String, String> map){
        Map<Object, Object> newMap = new LinkedHashMap<>();
        map.forEach(newMap::put);
        return newMap;
    }

    public static void displayMap(Map<Object, Object> map){
        map.forEach((k, v) -> System.out.println(k.toString() + " : " + v.toString()));
    }
}
