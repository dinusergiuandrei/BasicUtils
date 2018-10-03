package json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.TreeNode;
import datatypes.operations.trees.traversals.TreeDfsExecutor;
import datatypes.operations.trees.visitors.NodeVisitor;
import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.BasicTreeNode;
import filemanager.FileManager;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class JsonWriter {
    public void writeJson(String outputPath, BasicTree tree) throws IOException {
        TreeDfsExecutor executor = new TreeDfsExecutor();

        JsonFactory factory = new JsonFactory();
        JsonGenerator generator = factory.createGenerator(FileManager.computeOutputStream(outputPath));

        generator.writeStartObject();

        JsonTreeVisitor visitor = new JsonTreeVisitor(generator);
        executor.visitNodes(tree, visitor);

        generator.writeEndObject();

        generator.close();
    }

    private class JsonTreeVisitor implements NodeVisitor {
        private JsonGenerator generator;

        public JsonTreeVisitor(JsonGenerator generator) {
            this.generator = generator;
        }

        @Override
        public Object visitNode(BasicTreeNode node) {
            if (node.getData() instanceof JsonNodeData) { // leaf
                JsonNodeData jsonNodeData = (JsonNodeData) node.getData();

                if (jsonNodeData.getData() instanceof String) {
                    try {
                        generator.writeStringField(jsonNodeData.getName(), (String) jsonNodeData.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (jsonNodeData.getData() instanceof List) {
                    try {
                        generator.writeArrayFieldStart(jsonNodeData.getName());
                        List list = (List) jsonNodeData.getData();
                        for (Object field : list) {
                            generator.writeString(field.toString());
                        }
                        generator.writeEndArray();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else { // not leaf
                try {
                    generator.writeFieldName(node.getData().toString());
                    generator.writeStartObject();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
