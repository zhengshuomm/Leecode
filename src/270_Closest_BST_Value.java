/*Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ¡Ü total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 

Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Hint:

Consider implement these two helper functions:
getPredecessor(N), which returns the next smaller node to N.
getSuccessor(N), which returns the next larger node to N.
Try to assume that each node has a parent pointer, it makes the problem much easier.
Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
You would need two stacks to track the path in finding predecessor and successor node separately.*/
public class Closest_BST_Value_270 {
	 	int goal;
	    double min = Double.MAX_VALUE;
	 
	    public int closestValue(TreeNode root, double target) {
	        helper(root, target);
	        return goal;
	    }
	 
	    public void helper(TreeNode root, double target){
	        if(root==null)
	            return;
	 
	        if(Math.abs(root.val - target) < min){
	            min = Math.abs(root.val-target);
	            goal = root.val;
	        } 
	 
	        if(target < root.val){
	            helper(root.left, target);
	        }else{
	            helper(root.right, target);
	        }
	    }

}
