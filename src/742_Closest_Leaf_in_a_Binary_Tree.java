//https://zxi.mytechroad.com/blog/tree/742-closest-leaf-in-a-binary-tree/
//Given a binary tree where every node has a unique value, and a target key k, find the value of the closest leaf node to target k in the tree.
//
//Here, closest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
//
//In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

// parent 孩子 或者是自己的孩子
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap();
        dfs(graph, root, null);

        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> seen = new HashSet();

        for (TreeNode node: graph.keySet()) {
            if (node != null && node.val == k) {
                queue.add(node);
                seen.add(node);
            }
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (graph.get(node).size() <= 1)
                    return node.val;
                for (TreeNode nei: graph.get(node)) {
                    if (!seen.contains(nei)) {
                        seen.add(nei);
                        queue.add(nei);
                    }
                }
            }
        }
        throw null;
    }

    public void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if (node != null) {
            if (!graph.containsKey(node)) graph.put(node, new LinkedList<TreeNode>());
            if (!graph.containsKey(parent)) graph.put(parent, new LinkedList<TreeNode>());
            graph.get(node).add(parent);
            graph.get(parent).add(node);
            dfs(graph, node.left, node);
            dfs(graph, node.right, node);
        }
    }
}