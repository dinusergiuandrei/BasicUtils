package datatypes.operations.trees.visitors;

import datatypes.structure.trees.BasicTreeNode;

public interface NodeVisitor {
    Object visitNode(BasicTreeNode node);
}
