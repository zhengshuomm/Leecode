/*Method 1 (Uses Parent Pointer) 
In this method, we assume that every node has parent pointer. 
The Algorithm is divided into two cases on the basis of right subtree of the input node being empty or not.
Input: node, root // node is the node whose Inorder successor is needed.
output: succ // succ is Inorder successor of node.
1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
Go to right subtree and return the node with minimum key value in right subtree.
2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
Travel up using the parent pointer until you see a node which is left child of it¡¯s parent. The parent of such a node is the succ.*/

/*Method 2 (Don't Use Parent Pointer)
Inorder travel the tree and
1) If current visit node is target node,  mark the indicator as true.
2) If indicator is true, print the node and return.
*/
public class Inorder_Successor_in_Binary_Search_Tree_285 {
/*	public TreeNode successor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val <= p.val) {
    return successor(root.right, p);
  } else {
    TreeNode left = successor(root.left, p);
    return (left != null) ? left : root;
  }
}
}
