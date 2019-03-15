/*
	Main file for Binary Tree Lab
	@author Autumn C. Spaulding
	Creation Date: 24 July 2000
	
	More thorough documentation may be found within the BinaryTree class file.
*/

public class BinaryTreeLab
{

	public static void main(String args[])
	{
		 Debug.turnOn();
		//Debug.turnOff();


		//construct an empty binary tree here.
		BST tree = new BST();

		TranversalSum sum = new TranversalSum();
		ExtremeValueCalculator val = new ExtremeValueCalculator();
		//insert elements in level order here.
		addTrees(tree);
		//traverse the tree in breadth-first order to see what you have done.
		traverseTree(tree, sum);
        treeData(tree);
		treeComparable(tree);
		isBST(tree, val);
			
	}
	public static void addTrees(BST tree)
	{
		//insert elements in level order here.
		tree.add((Integer)12);
		tree.add((Integer)7);
		tree.add((Integer)3);
		tree.add((Integer)4);
		tree.add((Integer)8);
		tree.add((Integer)25);
		tree.add((Integer)0);
		tree.add((Integer)142);
		tree.add((Integer)17);
		tree.add((Integer)26);
	}
	public static void traverseTree(BST tree, TranversalSum sum)
	{
		NodeVisitor printer = new PrintAction();
        ExtremeValueCalculator val = new ExtremeValueCalculator();
		System.out.println("******Traversing Tree: breadth-first order******");
		tree.breadthFirstTraversal(printer, val);
		val.getMax();
		val.getMin();
		System.out.println("******Traversing Tree: Pre-order******");
		tree.PreOrderTraversal(printer, tree);
		System.out.println("******Traversing Tree: In-order******");
		tree.INOrderTraversal(printer, tree);
		System.out.println("******Traversing Tree: Out-order******");
		tree.OUTOrderTraversal(printer, tree);
		System.out.println("******Traversing Tree: isLeaf******");
		tree.isLeaf();
		tree.getLeaf();
		System.out.println("******Traversing Tree: Sum******");
		sum.sum(tree);
		sum.getSum();
	}
	public static void treeData(BST tree)
	{
		System.out.println("******Traversing Tree: Total Nodes******");
		tree.numNodes(tree);
		tree.getTotalNodes();
		System.out.println("******Traversing Tree: Total Leaves******");
		tree.leaves(tree);
		tree.getTotalLeaves();
		System.out.println("******Traversing Tree: Height******");
		tree.depth(tree);
		tree.getDepth();
	}
	public static void treeComparable(BST tree)
	{
        System.out.println("******Traversing Tree: Number of occurrences******");
        tree.numOcc(4,tree);
        tree.getnumOcc(4);
		System.out.println("******Traversing Tree: Is this object is in the tree******");
		tree.compareObj((Integer)8, tree);
        System.out.println("******Traversing Tree: Is this Tree the same as the other tree******");
        tree.equals(tree);
	}
	public static boolean isBST(BST tree, ExtremeValueCalculator val)
	{
		System.out.println("******Traversing Tree: Is this Tree a BST******");
		if(val.isLess(tree))
		{
			System.out.println(val.isLess(tree));
			return true;
		}
		else {
			System.out.println(val.isLess(tree));
			return false;
		}
	}

}	//end class BinaryTreeLab
