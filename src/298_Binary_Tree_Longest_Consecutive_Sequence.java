/*Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).*/

public class Binary_Tree_Longest_Consecutive_Sequence_298 {
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findLongest(root, 0, root.val - 1);
    }
    
    private int findLongest(TreeNode root, int length, int preVal){
        if(root == null){
            return length;
        }
        int currLen = preVal + 1 == root.val ? length + 1 : 1;
        return Math.max(currLen, Math.max(findLongest(root.left, currLen, root.val), findLongest(root.right, currLen, root.val)));  
    }
}
