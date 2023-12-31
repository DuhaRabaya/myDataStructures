public class MyLinkedList<T> {
   private Node head=new Node();
   private int size=0;
   private Node tail=new Node();
    public MyLinkedList()
    {
        head=null;
        tail=null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    public void addtostart(T n)
    {   //2
        // 5 2
        Node no=new Node(n , null);
        if(head==null)
        {
            head=no ; tail=head;
        }
        else
        {
            no.setNext(head);
            head=no;
        }
        size++;
    }
    public void addtoend(T n)
    {
        Node node=new Node(n , null);
        if(head==null)
        {
            head=node ; tail=head;
        }
        else
        {
            tail.setNext(node);
            tail=node;
        }
        size++;
    }
    public void addbyindex(T value , int index)
    {
        //1 2 4 6
        // 3  3
        // 1 2  3  4 6
        if(index<0 || index>size) throw new ArrayIndexOutOfBoundsException();
        else
        {
            Node n=new Node(value,null);
            if(index==1) addtostart(value);
            else  if(index==size) addtoend(value);
            else {
                Node cur = head;
                for (int i = 1; i <= index - 2; i++) {
                    cur = cur.getNext();
                }
                n.setNext(cur.getNext());
                cur.setNext(n);
            }
            size++;
        }
    }
    public void removefirst()
    {
        if(head==null) throw new ArrayIndexOutOfBoundsException();
        head=head.getNext();
        size--;
    }
    public void removefromlast()
    {
        if(head==null) throw new ArrayIndexOutOfBoundsException();
        Node cur=head;
        while(cur.getNext()!=tail)
        {
            cur=cur.getNext();
        }
        cur.setNext(null);
        tail=cur;
        size--;
    }
    public void removebyindex(int index)
    {
        if(head==null) throw new ArrayIndexOutOfBoundsException();
        else {
            if(index==1) removefirst();
            else if(index==size) removefromlast();
            else {
                Node cur = head;
                for (int i = 1; i < index - 1; i++) {
                    cur = cur.getNext();
                }
                cur.setNext(cur.getNext().getNext());
                size--;
            }
        }
    }
    public void print()
    {
        Node cur=head;
       while(cur!=null){
           System.out.print(cur.getData() +" ");
            cur=cur.getNext();
        }
        System.out.println();
    }
    public void addnode(Node n)
    {
        tail.setNext(n);
        tail=n;
        n.setNext(null);
    }
 public void reverse()
 {
     Node cur=head;
     Node prev=null;
     Node next=cur.getNext();
     while(next!=null && cur!=null)
     {
         next=cur.getNext();
         cur.setNext(prev);
         prev=cur;
         cur=next;
     }
     head=prev;
 }
 public Node mid()
 {
     Node slow=head;
     Node fast=head;
     while(fast!=null && fast.getNext()!=null)
     {
         fast=fast.getNext().getNext();
         slow=slow.getNext();
     }
     return slow;
 }
}
