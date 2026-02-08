class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}

public static void ex1(BinNode<Integer> t)
    {
        if (t == null) return;

        Queue<BinNode<Integer>> q = new Queue<>();
        q.insert(t);              

        while (!q.isEmpty())
        {
            BinNode<Integer> current = q.remove();       
            System.out.print(current.getValue() + " "); 

            if (current.hasLeft())  q.insert(current.getLeft());
            if (current.hasRight()) q.insert(current.getRight());
        }
    }
    
    public static void ex2(BinNode<Integer> t)
    {
        if (t == null) return;
    
        Queue<BinNode<Integer>> q = new Queue<>();
        q.insert(t);
        q.insert(null); 
    
        while (!q.isEmpty())
        {
            BinNode<Integer> current = q.remove();
    
            if (current == null)
            {
                System.out.println(); 
    
                if (!q.isEmpty())
                    q.insert(null);
            }
            else
            {
                System.out.print(current.getValue() + " ");
    
                if (current.hasLeft())  q.insert(current.getLeft());
                if (current.hasRight()) q.insert(current.getRight());
            }
        }
    }
    
    public static void ex3(BinNode<Integer> t) 
    {
        System.out.println(t.getValue());
        if(t.hasRight())
        {
            ex3(t.getRight());
        }
    }
    
    public static Node<Integer> ex4(BinNode<Integer> t, Node<Integer> l2) 
    {
        if (t == null)  return l2;
        Node<Integer> result = new Node<Integer>(t.getValue());
        if(t.hasRight())
        {
            l2.setNext(new Node<Integer>(t.getRight().getValue()));
            result = ex4(t.getRight(), l2.getNext());
        }
        if(t.hasLeft() && t.hasRight() == false)
        {
            l2.setNext(new Node<Integer>(t.getLeft().getValue()));
            result = ex4(t.getLeft(), l2.getNext());
        }
        return l2;
