package datatypes.structure;

public class Node<T> {
    protected T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
