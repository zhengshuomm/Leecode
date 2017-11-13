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
public class Closest_BST_Value_II_270 {
	/* 1 class Solution {
		 2 public:
		 3     vector<int> closestKValues(TreeNode* root, double target, int k) {
		 4         vector<int> closest(k);
		 5         stack<int> pre, suc;
		 6         inorder(root, target, false, pre);
		 7         inorder(root, target, true, suc);
		 8         for (int i = 0; i < k; i++) {
		 9             if (pre.empty()) closest[i] = suc.top(), suc.pop();
		10             else if (suc.empty()) closest[i] = pre.top(), pre.pop();
		11             else if (abs(target - pre.top()) < abs(target - suc.top()))
		12                 closest[i] = pre.top(), pre.pop();
		13             else closest[i] = suc.top(), suc.pop();
		14         }
		15         return closest;
		16     }
		17 private:
		18     void inorder(TreeNode* root, double target, bool reversed, stack<int>& s) {
		19         if (!root) return;
		20         inorder(reversed ? root -> right : root -> left, target, reversed, s);
		21         if ((reversed && root -> val <= target) || (!reversed && root -> val > target)) return;
		22         s.push(root -> val);
		23         inorder(reversed ? root -> left : root -> right, target, reversed, s);
		24     }
		25 };*/
}
