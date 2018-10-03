package json;

import datatypes.structure.trees.BasicTreeNode;

public class JsonNodeData {
    private String name;

    private Object data;

    public JsonNodeData(String name, Object data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return name + " -> " + data;
    }
}
