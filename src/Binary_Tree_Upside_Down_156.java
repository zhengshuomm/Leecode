/**Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
1
/ \
2 3
/ \
4 5

return the root of the binary tree [4,5,2,#,#,3,1].
4
/ \
5 2
  / \
 3 1
*/
/*public class Binary_Tree_Upside_Down_156 {
	public TreeNode UpsideDownBinaryTree(TreeNode root) {  
	    if (root == null)  
	        return null;  
	    TreeNode parent = root, left = root.left, right = root.right;  
	    if (left != null) {  
	        TreeNode ret = UpsideDownBinaryTree(left);  
	        left.left = right;  
	        left.right = parent;  
	        return ret;  
	    }  
	    return root;  
	}  
	
	
	public TreeNode UpsideDownBinaryTree(TreeNode root) {  
		TreeNode node = root;
		TreeNode left = null;
		TreeNode right = null;
		TreeNode parent = null;
		while (node != null){
			left = node.left;
			node.left = right;
			
			right = node.right;
			node.right = parent;
			parent = node;
			node = left;
		}
		return parent;
	}
}*/
