/*

The BinaryTree Class

@author Autumn C. Spaulding <a href="mailto:autumn@max.cs.kzoo.edu">email</a>
Creation Date: 24 July 2000

Modifications:
    Modifier: Alyce Brady
    Modification Date: November 11, 2002
    Modifications Made: Modifications to documentation (e.g., to remove
        empty preconditions); added levelOrderTraversal;
        also modified to use NodeAction interface.

Modifications:
    Modifier: studentName
    Modification Date: currentDate
    Modifications Made:

Description:
    This file contains some of the implementation of a BinaryTree class. 
    It is intended as an outline and starting point for the "Binary Trees"
    lab in the Data Structures course.  The implementation is based on the 
    recursive definition of a tree rather than on the graph theory definition
    of a tree (compare to Bailey, 190).
    
    A binary tree is either:
        1.  An empty tree; or
        2.  a node, called a root (the node contains the data), and two 
            children, left and right, each of which are themselves binary trees.
                (Berman, "Data Structures via C++: Objects by Evolution", 1997.)
    
    In this implementation, an empty tree is represented by a node with null
    data and null references for the children.  A leaf node is represented by
    a node with a data value and two references to empty trees (NOT a data
    value and two null references!).  We could represent this as an object
    invariant: data, left, right are either all null (representing an empty
    tree) or none of them are null (a non-empty tree).

*/

import javax.xml.soap.Node;

public class BinaryTree
{
    //data:
    protected Object data;
    protected BinaryTree left;
    protected BinaryTree right;
    public int total = 0;
    public int leaves = 0;
    public int height = 0;
    int max = 0;
    int counter = 0;
    int counterOCc = 0;
    /*tested*/
    /** Creates an empty binary tree with no data and no children. */
    public BinaryTree()
    {
        //this is the contructor for the BinaryTree object
        data = null;
        left = null;
        right = null;
    }
     
    /*tested*/
    /** Tests whether this is an empty tree.
            @return true if the tree is empty; false otherwise
    */
    public boolean isEmpty()
    {
        return data == null;
    }
   
    /*tested*/
    /** Gets the data associated with the root node of this particular tree
        (recall recursive definition of trees).
            @return value associated with tree's root node; 
                          null if tree is empty
    */
    public Object getElement()
    {
        return data;
    }

    /*tested*/
    /** Gets the left child of the current tree.
            @return the left child (a tree)
    */
    public BinaryTree leftTree()
    {
        return left;
    }

    /*tested*/
    /** Gets the right child of the current tree.
            @return the right child (a tree)
    */
    public BinaryTree rightTree()
    {
        return right;
    }

    /** Adds elements to a binary tree.  This implementation adds the
        elements in breadth-first (top-down, left-to-right) order.
            @param value the value to be added to the tree.
            @return true when the value has been added; should never return false
    */
    public boolean add(Object value)
    {
        KQueue queue = new LLQueue();
        queue.enqueue(this);
        while( ! queue.isEmpty() )
        {
            BinaryTree tree = (BinaryTree)queue.dequeue();

            //if the current position is null, then we know we can place a
            //value here.
            //place the value in that position in the tree, and create new
            //BinaryTrees for its children, which will both initially be null.
            if (tree.isEmpty())
            {
                tree.data = value;
                tree.left = new BinaryTree();
                tree.right = new BinaryTree();
                return true;
            }
            //otherwise, if the position is not null (that is, we can't place
            //it at the current position), then we add the left and right children
            //to the queue (if we can) and go back to the beginning of the loop.
                queue.enqueue(tree.left);
                queue.enqueue(tree.right);

        }
        return false;    //this statement should never be executed.
    }

	/** Traverses the tree in breadth-first order.
	        @param action an object that will act on all the nodes in the tree
	*/
        public void breadthFirstTraversal(NodeVisitor action, ExtremeValueCalculator val)
	{
		KQueue queue = new LLQueue();
		queue.enqueue(this);
		while( ! queue.isEmpty() )
		{
			BinaryTree tree = (BinaryTree)queue.dequeue();
			if ( ! tree.isEmpty() )
            {
    			action.visit(tree.getElement());
    			val.visit(tree.getElement());
    			queue.enqueue(tree.leftTree());
    			queue.enqueue(tree.rightTree());

            }
		}
	}
    public void PreOrderTraversal(NodeVisitor action, BinaryTree tree) {
            if ( ! tree.isEmpty() )
            {
                action.visit(tree.getElement());
                PreOrderTraversal(action, tree.leftTree());
                PreOrderTraversal(action, tree.rightTree());
            }
    }
    public void INOrderTraversal(NodeVisitor action, BinaryTree tree) {
        if ( ! tree.isEmpty() )
        {
            PreOrderTraversal(action, tree.leftTree());
            action.visit(tree.getElement());
            PreOrderTraversal(action, tree.rightTree());
        }
    }
    public void OUTOrderTraversal(NodeVisitor action, BinaryTree tree) {
        if ( ! tree.isEmpty() )
        {
            PreOrderTraversal(action, tree.leftTree());
            PreOrderTraversal(action, tree.rightTree());
            action.visit(tree.getElement());
        }
    }
    /*returns true if the node is a leaf node; false otherwise*/
    public boolean isLeaf()
    {
        if(!this.isEmpty())
        {
            this.getElement();
            if((this.right.isLeaf() == false) && (this.left.isLeaf() == false)) {
                return false;
            }
            else
            {
                return true;
            }
        }
        return true;

    }
    public void getLeaf()
    {
        if(this.rightTree().isLeaf() == true || this.leftTree().isLeaf() == true)
        {
            System.out.println("This is not a leaf:" + this.getElement());
        }
        if(this.rightTree().isLeaf() == false || this.leftTree().isLeaf() == false)
        {
            System.out.println("This element is a leaf:" + this.getElement());
        }

    }
    public int numNodes(BinaryTree tree)
    {

        if(!tree.isEmpty())
        {
            tree.getElement();
            total++;
            numNodes(tree.leftTree());
            numNodes(tree.rightTree());
        }
        return total;
    }
    public void getTotalNodes()
    {
        System.out.println("The total nodes inside this tree is: " + total + ".");
    }
    public void leaves(BinaryTree tree)
    {
        if(!tree.isEmpty())
        {
            tree.getElement();
            if(tree.rightTree().isEmpty() == false || tree.leftTree().isEmpty() == false) {

                //System.out.println("This is not a leaf:" + tree.getElement());
                leaves(tree.leftTree());
                leaves(tree.rightTree());
            }
            else
            {
                //System.out.println("This element is a leaf:" + tree.getElement());
                leaves++;
            }
        }
    }
    public void getTotalLeaves()
    {
        System.out.println("The total leaves inside this tree is: " + leaves + ".");
    }
    public void depth(BinaryTree tree)
    {

        if(!tree.isEmpty())
        {
            tree.getElement();
            height++;
            depth(tree.leftTree());
            depth(tree.rightTree());
        }
        else
        {
            if(height > max)
            {
                max = height;
                height = 0;
            }
        }

    }
    public void getDepth()
    {
        System.out.println("The total height of this tree is: " + max + ".");
    }
    public boolean compareObj(Object object, BinaryTree tree)
    {
        if(!tree.isEmpty())
        {
            tree.getElement();
            if(tree.getElement() != object)
            {
                if(!compareObj(object, tree.leftTree()) && !compareObj(object, tree.rightTree()))
                {
                    return false;
                }
                /*if(tree.isEmpty() && compareObj(object, (BinaryTree) tree.getElement()) == false){
                    System.out.println("The element wanted was: " + object + " It was not found");

                }*/
            }
            else
            {
                System.out.println("The element wanted was: " + object + " It was found: " + tree.getElement());
                return true;
            }

        }
        return false;

    }
    public int numOcc(Object object, BinaryTree tree)
    {
        if(!tree.isEmpty())
        {
            tree.getElement();

            if(tree.getElement() == object)
            {
                counterOCc++;
            }
            numOcc(object, tree.leftTree());
            numOcc(object, tree.rightTree());
        }
        return counter;

    }
    public void getnumOcc(Object object)
    {
        System.out.println("The number of occurences for: " + object + " is equal to: " + counterOCc);
    }
    public boolean equals(Object object)
    {
        BinaryTree newtree = (BinaryTree)object;
        if(!newtree.isEmpty() && !this.isEmpty())
        {
            if(this.isLeaf())
            {
                if(newtree.isLeaf()) {
                if(newtree.getElement() == this.getElement())
                {
                    if( equals(newtree.leftTree()) && equals(this.leftTree()))
                    {
                        System.out.println("The left trees are equal");
                        return true;
                    }
                    if(equals(newtree.rightTree()) && equals(this.rightTree()))
                    {
                        System.out.println("The left trees are equal");
                        return true;
                    }
                    System.out.println("Neither left or right trees are equal");
                }
                System.out.println("These trees are not equal");
                return false;
                }
            }
            else
            {
                return false;
            }
        }
        System.out.println("The tree is empty");
        return false;
    }

}    //end class BinaryTree
