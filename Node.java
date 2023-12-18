public class Node<T> {
    private T data;
    private Node next;

    public Node() {
    }

    public Node(T t , Node n)
    {
        this.data=t; this.next=n;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


