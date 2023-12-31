import java.util.*;
public class myArrayList<T> {
    int size=0;
    int capacity=1;
    T []arr=(T[])new Object[capacity];
    public myArrayList()
    {
    }
    public void ensurecapacity()
    {
        if(size==capacity)
        {
            capacity*=2;
            T []arr2=(T[]) new Object [capacity];
            for(int i=0 ;i<size ; i++)
            {
                arr2[i]=arr[i];
            }
            arr=arr2;
        }
    }
    public void add(T x)
    {
       ensurecapacity();
        arr[size]=x;
        size++;
    }
    public T get(int x)
    {
        if(x<0 || x>=size)
           throw new ArrayIndexOutOfBoundsException("index not right");

         else return arr[x];
    }
    public String tostring()
    {
    String res="[";
    for(int i=0 ;i<size ;i++)
    {
        if(i==size-1) res+=arr[i];
        else res+=arr[i]+" , ";
    }
    res+=']';
    return res;
    }
    public int getSize()
    {
        return size;
    }
    public T getlast()
    {
        if(size==0) throw new ArrayIndexOutOfBoundsException();
        return arr[size-1];
    }
    public void removelast()
    {
        if(size==0) System.out.println("empty");
        else
        {
            size--;
        }
    }
    public void addbyindex( int index,T value)
    {
        if(index>=0 && index<=size)
        {
            ensurecapacity();
            for (int i = size; i > index; i--)
                arr[i] = arr[i-1];

            arr[index] = value;
            size++;
        }
        else throw new ArrayIndexOutOfBoundsException();

    }
    public void addfirst(T value)
    {
    // addbyindex(value,0);
        ensurecapacity();
        for (int i = size; i > 0; i--)
            arr[i] = arr[i-1];

        arr[0] = value;
        size++;
    }
    public void set(int index , T value)
    {
        if (index<0 || index>=size) throw new ArrayIndexOutOfBoundsException();
        arr[index]=value;
    }
  public boolean contains(T value)
  {
      for(int i=0 ;i<size ;i++)
      {
          if(arr[i]==value) return true;
      }
      return false;
  }
  public int indexof(T value)
  {
      for(int i=0 ;i<size ;i++)
      {
          if(arr[i]==value) return i;
      }
      return -1;
  }
  public T removebyindex(int index)
  {
      T value=arr[index];
      if(size ==0  || index<0 || index>=size) throw new ArrayIndexOutOfBoundsException();
      for(int i=index ;i<size-1 ;i++)
          arr[i]=arr[i+1];

      size--;
      return value;

  }
  public int IndexOf(T value)
  {
      for(int i=0 ;i<size ;i++)
          if (get(i).equals(value)) {
              return i;
          }
      return -1;
  }
  public void AddAll(myArrayList list)
  {
      for(int i=0 ;i<list.size ; i++) {
          this.add( (T) list.get(i) );
      }

  }
  public void reverse()
  {
      T[] rev=(T[])new Object[this.size];

      for(int i=size-1,j=0 ; i>=0 ;i--,j++)
          rev[j]=this.get(i);


      arr=rev;

  }
    public int palindrome(){
        int c=0,c2=0;
        for(int i=0,j=size-1;i<j;){
            if(arr[i].equals(arr[j])){i++;j--;}
            else {i++; c++;}
        }
        myArrayList<T>a=this;
        a.reverse();
        for(int i=0,j=size-1;i<j;){
            if(arr[i].equals(arr[j])){i++;j--;}
            else {i++; c2++;}
        }
        return c<c2?c:c2;
    }
    public myArrayList<T> duplicate()
    {
        myArrayList myarr=new myArrayList();
        for(int i=0 ;i<this.size ; i++)
        {
            myarr.add(this.get(i));
        }
        return myarr;
    }
   public static myArrayList<Integer> mergeTwoSortedLists(myArrayList<Integer> a,myArrayList<Integer> b) {
       myArrayList<Integer>  res = new myArrayList<>();

        int i = 0, j = 0;
        while (i < a.size && j < b.size) {
            if (a.get(i) < b.get(j)) {
                res.add(a.get(i++));
            } else {
                res.add(b.get(j++));
            }
        }
        while (i < a.size)
            res.add(a.get(i++));
        while (j < b.size)
            res.add(b.get(j++));
        return res;
    }
}
