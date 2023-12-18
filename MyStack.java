public class MyStack <T> {
Node top;
int size;
MyStack()
{
    top=null;
    size=0;
}
public void push(T value)
{
    Node n=new Node(value , null);
    if(top==null) {
        top = n;
    }
    else
    {
        n.setNext(top);
        top=n;
    }
    size++;
}
public T pop()
{
    if(top==null)  throw new ArrayIndexOutOfBoundsException();
    T value= (T) top.getData();
    top=top.getNext();
    size--;
    return value;
}
public T peek()
{
    return (T) top.getData();
}
public int size()
{
    return size;
}
public boolean isempty()
{
    return top==null;
}
public MyStack rev()
{
    MyStack st=new MyStack();
    while(top!=null)
    {
        st.push(this.pop());
    }
    return st;
}
    public String tostring()
    {
        String s="[";
        Node cur=top;
        for(int i=0 ;i<size ; i++)
        {
            if(i==size-1)  s+=cur.getData()+" ]";
            else {
                s += cur.getData() + " , ";
                cur = cur.getNext();
            }
        }

        return s;
    }
    public void printtotop()
    {
        helperprinttptop(top);
        System.out.println();
    }
    public void helperprinttptop(Node cur)
    {
        if(cur==null)return;
        helperprinttptop(cur.getNext());
        System.out.print(cur.getData()+ " ");
    }

}
