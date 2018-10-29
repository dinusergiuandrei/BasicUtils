package json;


import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.TreeNode;
import filemanager.FileManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class JsonParser {

    public BasicTree parse(String sourcePath) throws IOException {
        JSONObject obj = new JSONObject(FileManager.getTextFromFile(sourcePath));

        BasicTree tree = new BasicTree();

        TreeNode<String> root = new TreeNode<>("root", null);
        tree.addNode(root);

        parseObject(obj, root, tree);

        return tree;
    }

    private void parseObject(JSONObject object, TreeNode parent, BasicTree tree) {
        object.keySet().forEach(
                key -> {
                    Object value = object.get(key);

                    if(value instanceof JSONObject){
                        JSONObject childObject = object.getJSONObject(key);

                        TreeNode<String> node = new TreeNode<>(key, parent);
                        tree.addNode(node);

                        parseObject(childObject, node, tree);
                    }

                    if(value instanceof String){
                        TreeNode<JsonNodeData> leaf = new TreeNode<>(new JsonNodeData(key, value), parent);
                        tree.addNode(leaf);
                    }

                    if(value instanceof JSONArray){
                        JSONArray array = (JSONArray) value;
                        TreeNode<JsonNodeData> leaf = new TreeNode<>(new JsonNodeData(key, array.toList()), parent);
                        tree.addNode(leaf);
                    }
                }
        );

    }
}
