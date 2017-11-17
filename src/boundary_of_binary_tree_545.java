//Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
//
//Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
//
//The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
//
//The right-most node is also defined by the same way with left and right exchanged.
//
//Example 1
//
//Input:
//  1
//   \
//    2
//   / \
//  3   4
//
//Ouput:
//[1, 3, 4, 2]
public class boundary_of_binary_tree_545 {
	List<Integer> nodes = new ArrayList<>(1000);
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	    
	    if(root == null) return nodes;

	    nodes.add(root.val);
	    leftBoundary(root.left);
	    leaves(root.left);
	    leaves(root.right);
	    rightBoundary(root.right);
	    
	    return nodes;
	}
	public void leftBoundary(TreeNode root) {
	    if(root == null || (root.left == null && root.right == null)) return;
	    nodes.add(root.val);
	    if(root.left == null) leftBoundary(root.right);
	    else leftBoundary(root.left);
	}
	public void rightBoundary(TreeNode root) {
	    if(root == null || (root.right == null && root.left == null)) return;
	    if(root.right == null)rightBoundary(root.left);
	    else rightBoundary(root.right);
	    nodes.add(root.val); // add after child visit(reverse)
	}
	public void leaves(TreeNode root) {
	    if(root == null) return;
	    if(root.left == null && root.right == null) {
	        nodes.add(root.val);
	        return;
	    }
	    leaves(root.left);
	    leaves(root.right);
	}
}
