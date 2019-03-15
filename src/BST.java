import java.util.Comparator;

/**
 * Created by fdebi on 5/15/2017.
 */
public class BST extends BinaryTree {
    Comparable previous;
    @Override
    public boolean add(Object value) {
        //ExtremeValueCalculator val = new ExtremeValueCalculator();
            //if the current position is null, then we know we can place a
            //value here.
            //place the value in that position in the tree, and create new
            //BinaryTrees for its children, which will both initially be null.
            if (this.isEmpty()) {
                previous = (Comparable) value;
                this.data = value;
                this.left = new BST();
                this.right = new BST();
                return true;
            }
            //otherwise, if the position is not null (that is, we can't place
            //it at the current position), then we add the left and right children
            //to the queue (if we can) and go back to the beginning of the loop.
            if ( ((Comparable)this.data).compareTo((Comparable) value) >= 0 ) {
               return this.leftTree().add(value);
            } else if(((Comparable)this.data).compareTo((Comparable) value) < 0 ) {
                return this.rightTree().add(value);
            }
        return false;    //this statement should never be executed.
    }
    private Object leftmsot(BinaryTree tree)
    {
        if(tree.leftTree().isEmpty())
        {
            return tree.getElement();
        }
        return leftmsot(tree.leftTree());
    }
    private Comparable DeleteLeft()
    {
        if(left.leftTree().isEmpty())
        {
            Comparable leftval = (Comparable) left.getElement();
            left = left.rightTree();
            System.out.println(leftval);
            return leftval;
        }
        else
        {
           return ((BST)left).DeleteLeft();
        }
    }
    public boolean removeNode(Comparable comp)
    {
        boolean toReturn = false;
        if(comp.compareTo(this.data) == 0) {
            if (this.isLeaf()) {
                this.data = null;
                left = null;
                right = null;
                return true;
            }
            else
            {
                this.data = left.data;
                right = this.rightTree();
                toReturn = ((BST)leftTree()).removeNode((Comparable)left.data);
            }
        }
        else
        {
            if(comp.compareTo(this.data) >= 0) {
                toReturn = ((BST)rightTree()).removeNode(comp);
            }
            else {
                toReturn = ((BST)leftTree()).removeNode(comp);
            }
        }

        return toReturn;
    }
}