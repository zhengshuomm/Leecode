
public class Closest_Binary_Search_Tree_Value_II_277 {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		  List<Integer> res = new ArrayList<>();

		  Stack<Integer> s1 = new Stack<>(); // predecessors
		  Stack<Integer> s2 = new Stack<>(); // successors

		  inorder(root, target, false, s1);
		  inorder(root, target, true, s2);
		  
		  while (k-- > 0) {
		    if (s1.isEmpty())
		      res.add(s2.pop());
		    else if (s2.isEmpty())
		      res.add(s1.pop());
		    else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
		      res.add(s1.pop());
		    else
		      res.add(s2.pop());
		  }
		  
		  return res;
		}

		// inorder traversal
		void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
		  if (root == null) return;

		  inorder(reverse ? root.right : root.left, target, reverse, stack);
		  // early terminate, no need to traverse the whole tree
		  if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
		  // track the value of current node
		  stack.push(root.val);
		  inorder(reverse ? root.left : root.right, target, reverse, stack);
		}
}

List<Integer> closestKValues(TreeNode root, double target, int k) {
	List<Integer> result = new ArrayList<>();
	if (root == null || k < 0) return result;
	helper(root, target, k, result);
	return result;
}

void helper(TreeNode node, double target, int k, List<Integer> result){
	if (node == null) return;
	helper(node.left, target, k, result);
	if (result.size() < k) result.add(node.val);
	else {
		double diff = math.abs(target - node.val);
		double oldDiff = Math.abs(target - result.get(0));
		if (diff < oldDiff) {
			result.remove(0);
			result.add(node.val);
		}else return;
	}
	helper(node.right, target, k, result);
}
}
