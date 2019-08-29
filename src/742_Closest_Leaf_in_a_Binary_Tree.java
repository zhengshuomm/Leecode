//https://zxi.mytechroad.com/blog/tree/742-closest-leaf-in-a-binary-tree/
//Given a binary tree where every node has a unique value, and a target key k, find the value of the closest leaf node to target k in the tree.
//
//Here, closest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
//
//In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

// parent 孩子 或者是自己的孩子
int answer;

public int findClosest(TreeNode root, int key) {
    answer = Integer.MAX_VALUE;
    helper(root, key, new ArrayList<TreeNode>());
    return answer;
}

private void helper(TreeNode node, int key, List<TreeNode> path) {
    if (node == null) {
        return;
    } else if (node.val != key) {
        path.add(node);
        helper(node.left, key, path);
        helper(node.right, key, path);
        path.remove(path.size() - 1);
    } else {
        // key matches with current node value
        answer = lenToLowerLeaf(node);
        // answer initially = cloest leaf from lower

        int len = path.size();
        for (int i = 0; i < len; i++) {
            // for every ancestor, calculate distance and compare
            int ithToLowerLeaf = lenToLowerLeaf(path.get(i));
            answer = Math.min(answer, (len - i) + ithToLowerLeaf);
        }
    }
}

private int lenToLowerLeaf(TreeNode node) {
    if (node == null) {
        return Integer.MAX_VALUE;
    } else if (node.left == null && node.right == null) {
        return 0;
    } else {
        return 1 + Math.min(lenToLowerLeaf(node.left), lenToLowerLeaf(node.right));
    }
}