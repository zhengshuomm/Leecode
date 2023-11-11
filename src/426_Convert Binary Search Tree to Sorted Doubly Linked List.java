class Solution {
    private Node head;
    private Node tail;
    private Node prev;
    public Node treeToDoublyList(Node root) {
        if(null == root) return null;
        
        dfs(root);
        tail.right = head;
        head.left = tail;
        
        return head;
    }
    void dfs(Node node) {
        if(null == node) return;
        dfs(node.left);
        
        Node cur = new Node(node.val);
        if(null == head) {
            head = cur;
        }
        if(null != prev) {
            prev.right = cur;
            cur.left = prev;
        }
        prev = cur;
        tail = cur;
        dfs(node.right);
    }
}

    public void inorderTraversal(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        Node prevNode = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            Node visitNode = stack.pop();
            visitNode.left = prevNode;
            if (prevNode != null)
                prevNode.right = visitNode;
            node = visitNode.right;
            prevNode = visitNode;
        }
    }
