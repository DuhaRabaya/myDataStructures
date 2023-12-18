public class myBST {
  private  Nodebst root;
  myBST()
  {
      root=null;
  }

    public Nodebst getRoot() {
        return root;
    }

    public void setRoot(Nodebst root) {
        this.root = root;
    }
   public boolean search(int x)
    {
        Nodebst p=root;
            while(p!=null)
            {
                if(p.getVal()==x) return true;
                if(x>p.getVal())
                    p=p.getRight();
                else p=p.getLeft();
            }
        return false;
    }
    public int getmin()
    {
        Nodebst p=root;
        while(p.getLeft()!=null)
        {
            p=p.getLeft();
        }
        return p.getVal();
    }
    public int getmax()
    {
        Nodebst p=root;
        while(p.getRight()!=null)
        {
            p=p.getRight();
        }
        return p.getVal();
    }
    public boolean isEmpty()
    {
        return root==null;
    }
    public void add(int x)
    {
        if(search(x)) return ;
        Nodebst p=new Nodebst(x);
        Nodebst t= root; // parent
        if(root==null){ root=p; return;}
        while(true)
        {
            if(x>t.getVal())
            {
                if(t.getRight()==null) break;
                t=t.getRight();
            }
            else
            {
                if(t.getLeft()==null) break;
                t=t.getLeft();
            }
        }
        if(x>t.getVal()) t.setRight(p);
        else t.setLeft(p);
    }
public void DFS(Nodebst n)// left root right
{
  if(n==null) return;
    DFS(n.getLeft());
    System.out.print(n.getVal()+"->");
    DFS(n.getRight());
}
public void printin()
{
    DFS(root);

}
    public void printpost()
    {
        postorder(root);

    }
public void postorder(Nodebst p)//left right root
{
    if(p==null) return;
    postorder(p.getLeft());
    postorder(p.getRight());
    System.out.print(p.getVal()+"->");
}
    public void printpre()
    {
        preorder(root);

    }
    public void preorder(Nodebst p)//root left right
    {
        if(p==null) return;
        System.out.print(p.getVal()+"->");
        postorder(p.getLeft());
        postorder(p.getRight());
    }
    public void insert(int x)
    {
        root=insert(root,x);
    }
    public Nodebst insert(Nodebst p , int v)
    {
        if(p==null) {
            p = new Nodebst(v);
            return p;
        }
        if(v>p.getVal())
            p.setLeft(insert(p.getLeft() ,v));
        else  if(v<p.getVal())
            p.setRight(insert(p.getRight(),v));

        return p;

    }
    public void delete(int e)
    {
        Nodebst p=null;
        Nodebst cur=root;
        while(cur!=null)
        {
            if(e<cur.getVal()) {
                p=cur;
                cur=cur.getLeft();
            }
            else if (e > cur.getVal()) {
                    p = cur;
                    cur = cur.getRight();
                }

            else break;
        }
        if(cur==null) return; // element is not in the tree
        if(cur.getLeft()==null) // cur has no left child
        {
            if(p==null) root=cur.getRight(); // e is the root -> delete the root
            else if(e<p.getVal()) p.setLeft(cur.getRight());
            else p.setRight(cur.getRight());
        }
        else // cur has a left child
        {
            Nodebst pofrightmost=cur;
            Nodebst rightmost=cur.getLeft();
            while(rightmost.getRight()!=null)
            {
                pofrightmost=rightmost;
                rightmost=rightmost.getRight();
            }
            cur.setVal(rightmost.getVal());

            if(pofrightmost.getRight()==rightmost)
                pofrightmost.setRight(rightmost.getLeft());
            else pofrightmost.setLeft(rightmost.getLeft());
        }
    }
public void clear()
{
    root=null;
}
}
