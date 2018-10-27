package datatypes.operations.visitors;

import datatypes.structure.Node;

public interface NodeVisitor {
    Object visitNode(Node node);
}
