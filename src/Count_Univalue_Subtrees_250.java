/*Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.*/
public class Count_Univalue_Subtrees_250 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(0);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		System.out.println(countUnivalSubtrees(root).number);
	}
	
	public static Result countUnivalSubtrees(TreeNode root) {
		if (root == null) return new Result(0, true);
		Result left = countUnivalSubtrees(root.left);
		Result right = countUnivalSubtrees(root.right);
		TreeNode l = root.left ;
		TreeNode r = root.right;
		if (left.flag && right.flag && ((l != null && root.val == l.val) || l == null) && ((r != null && root.val == r.val) || r == null)){
			return new Result(left.number + right.number + 1, true);
		}else{
			return new Result(left.number + right.number, false);
		}
	}
	
	static class Result{
		public Result(int number, boolean flag){
			this.number = number;
			this.flag = flag;
		}
		int number;
		boolean flag;
	}
}
