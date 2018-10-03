package json;


import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.BasicTreeNode;
import filemanager.FileManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class JsonParser {

    public BasicTree parse(String sourcePath) throws IOException {
        JSONObject obj = new JSONObject(FileManager.getTextFromFile(sourcePath));

        BasicTree tree = new BasicTree();

        BasicTreeNode<String> root = new BasicTreeNode<>("root", null);
        tree.addNode(root);

        parseObject(obj, root, tree);

        return tree;
    }

    private void parseObject(JSONObject object, BasicTreeNode parent, BasicTree tree) {
        object.keySet().forEach(
                key -> {
                    Object value = object.get(key);

                    if(value instanceof JSONObject){
                        JSONObject childObject = object.getJSONObject(key);

                        BasicTreeNode<String> node = new BasicTreeNode<>(key, parent);
                        tree.addNode(node);

                        parseObject(childObject, node, tree);
                    }

                    if(value instanceof String){
                        BasicTreeNode<JsonNodeData> leaf = new BasicTreeNode<>(new JsonNodeData(key, value), parent);
                        tree.addNode(leaf);
                    }

                    if(value instanceof JSONArray){
                        JSONArray array = (JSONArray) value;
                        BasicTreeNode<JsonNodeData> leaf = new BasicTreeNode<>(new JsonNodeData(key, array.toList()), parent);
                        tree.addNode(leaf);
                    }
                }
        );

    }
}
