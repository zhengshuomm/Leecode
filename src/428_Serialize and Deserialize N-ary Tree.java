/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {


    public String serialize(Node root) {
        if (root == null) return "";
        Queue<Node> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(root.val)).append(",#,");
        que.add(root);

        while (!que.isEmpty()) {
            Node node = que.poll();
            for (Node n : node.children) {
                sb.append(Integer.toString(n.val)).append(",");
                que.add(n);
            }
            sb.append("#,");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) return null;
        String[] s = data.split(",");
        Queue<Node> que = new LinkedList<>();
        Node root = new Node(Integer.parseInt(s[0]), new ArrayList<Node>());
        que.add(root);
        int i = 1;
        System.out.println(Arrays.toString(s));
        while (!que.isEmpty()) {
            Node node = que.poll();
            i++;
            while (!s[i].equals("#")) {
                Node c = new Node(Integer.parseInt(s[i]), new ArrayList<>());
                node.children.add(c);
                que.add(c);
                i++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));