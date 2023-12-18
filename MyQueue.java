import java.util.EmptyStackException;

public class MyQueue <T> {
    Node first;
    Node last;
    int size;

    MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(T value) {
        Node n = new Node<>(value, null);
        if (last == null) {
            first = n;
            last = n;
        } else {
            last.setNext(n);
            last = n;
        }
        size++;
    }

    public Node dequeue() {
        if (size == 0) throw new EmptyStackException();
        if (size == 1) {
            Node f = first;
            first = null;
            last = null;
            size--;
            return f;
        } else {
            Node f = first;
            first = first.getNext();
            size--;
            return f;
        }


    }

    public String tostring() {
        if (size == 0) throw new EmptyStackException();
        else {
            String s = "[";
            Node cur = first;
            for (int i = 0; i < size; i++) {
                if (cur.getNext() == null) s += cur.getData() + "]";
                else {
                    s += cur.getData() + ",";
                    cur = cur.getNext();
                }
            }
            return s;
        }
    }

    public int size() {
        return size;
    }

    public boolean isempty() {
        return (first == null);
    }

    public T peek() {
        if (isempty()) throw new EmptyStackException();
        else
            return (T) first.getData();
    }

    public void addbyindex(T value, int index) {
        if (index < 0 || index > size) return;

        Node cur = first;
        int i = 0, c = size + 1;
        while (c-- != 0) {
            if (i == index) {
                this.enqueue(value);
                i++;
            } else {
                Node saved = cur;
                cur = cur.getNext();
                i++;
                this.dequeue();
                this.enqueue((T) saved.getData());

            }
        }
    }

    public void swap(int n1, int n2) {
        if (n1 < 0 || n2 < 0 || n1 >= size() || n2 >= size()) {
            return;
        }

        Node cur = first;
        Node node1 = cur;
        Node node2 = cur;
        int i = 0;
        while (i <= size + 1) {
            if (i == n1) {
                node1 = cur;
                cur = cur.getNext();
                this.dequeue();
            } else if (i == n2) {
                node2 = cur;
                cur = cur.getNext();
                this.dequeue();

            } else {
                Node saved = cur;
                cur = cur.getNext();
                this.dequeue();
                this.enqueue((T) saved.getData());
            }
            i++;
        }
        this.addbyindex((T) node2.getData(), n1);
        this.addbyindex((T) node1.getData(), n2);
    }


    public void rev() {
        helperrev(first);
        System.out.println();
    }

    public void helperrev(Node cur) {
        if (cur == null) return;
        helperrev(cur.getNext());
        System.out.print(cur.getData() + " ");
    }

    public void deletebyindex(int index) {

        Node cur = first;
        Node node1 = cur;
        int i = 0;
        while (i <= size) {
            if (index == i) {
                node1 = cur;
                cur = cur.getNext();
                dequeue();
            } else {
                Node saved = cur;
                cur = cur.getNext();
                dequeue();
                enqueue((T) saved.getData());
            }
            i++;
        }
    }
}

