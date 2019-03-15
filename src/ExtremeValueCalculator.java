/**
 * Created by fdebi on 5/13/2017.
 */
public class ExtremeValueCalculator implements NodeVisitor {
    int max = 0;
    int min = 0;
    int replacer = 0;
    @Override
    public void visit(Object data) {
        if(data != null) {
            if(max < min)
            {
                replacer = max;
                max = min;
                min = replacer;
            }
            else if(min > (int)data)
            {
                min = (int)data;
            }
            else if(max < (int)data)
            {
                max = (int) data;
            }

        }

    }
    public ExtremeValueCalculator()
    {

    }
    public void getMin()
    {
        System.out.println("The extreme min value is: " + min);
    }
    public void getMax()
    {
        System.out.println("The extreme max value is: " + max);
    }
    public boolean isLess(BST tree)
    {
        if(tree.isEmpty())
        {
            return true;
        }
        if(((Comparable) tree.data).compareTo( (Comparable)tree.left.data) >=0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
