/**
 * Created by fdebi on 5/8/2017.
 */
public class TranversalSum implements NodeVisitor{
    private int Sum;

    public TranversalSum()
    {
        Sum = 0;
    }

    public Integer sum(BinaryTree tree)
    {
       if(!tree.isEmpty())
       {
           visit((int)tree.getElement());
           sum(tree.leftTree());
           sum(tree.rightTree());

       }
       return Sum;
    }
    public void visit(Object data)
    {
        if ( data != null )
            Sum+=(int)data;
            //System.out.println (data.toString());
    }
    public void getSum()
    {
        System.out.println("The sum of the elements is: " + Sum);
    }
}
