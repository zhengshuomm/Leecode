//Input:
//regions = [["Earth","North America","South America"],
//["North America","United States","Canada"],
//["United States","New York","Boston"],
//["Canada","Ontario","Quebec"],
//["South America","Brazil"]],
//region1 = "Quebec",
//region2 = "New York"
//Output: "North America"

class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Node root = buildTree(regions);
        Node node = lca(root, region1, region2);
        return node.val;
    }
    
    private Node lca(Node root, String region1, String region2) {
        if (root == null) return null;
        if (root.val.equals(region1) ||root.val.equals(region2)  ) return root;
        Node ancestor = null;
        for (Node node: root.children) {
            Node n = lca(node, region1, region2);
            if (n == null) continue;
            if (ancestor == null) {
                ancestor = n;
            }else {
                return root;
            }
        }
        return ancestor;
    }
    
    private Node buildTree(List<List<String>> regions) {
        Node root = null;
        Map<String, Node> map= new HashMap<>();
        for (int i = 0 ; i < regions.size() ; i ++) {
            List<String> list = regions.get(i);
            String parent = list.get(0);
            Node parentNode = map.getOrDefault(parent, new Node(parent));
            if (i == 0) root = parentNode;
            map.putIfAbsent(parent, parentNode);
            for (int j = 1 ; j < list.size(); j ++) {
                String name = list.get(j);
                Node node = new Node(name);
                map.putIfAbsent(name, node);                
                parentNode.children.add(node);
            }
        }
        return root;
    }
    
    class Node{
        String val;
        List<Node> children;
        public Node(String val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }
}