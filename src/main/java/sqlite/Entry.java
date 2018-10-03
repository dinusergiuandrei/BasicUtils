package sqlite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entry {
    private List<Object> objects = new ArrayList<>();

    public Entry(Object... objects) {
        this.objects = Arrays.asList(objects);
    }

    public List<Object> getObjects() {
        return objects;
    }
}
