class Codec {
    // 难
    public TreeNode encode(Node root) {
        if(root == null) return null;
        TreeNode curr = new TreeNode(root.val);
        if(root.children == null || root.children.size() == 0) return curr;
        curr.right = encode(root.children.get(0));
        TreeNode r = curr.right;
        for(int i=1;i<root.children.size();i++){
            r.left = encode(root.children.get(i));
            r = r.left; 
        }
        return curr;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;
        Node curr = new Node(root.val, new ArrayList<Node>());
        if(root.right == null) return curr;
        curr.children.add(decode(root.right));
        TreeNode remaining = root.right;       
        while(remaining.left != null) {
            curr.children.add(decode(remaining.left));
            remaining = remaining.left;
        }
        return curr;
    }
}