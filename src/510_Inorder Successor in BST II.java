class Solution {
    public Node inorderSuccessor(Node x) {

        if (x.right == null){
            while (x.parent != null && x == x.parent.right) {
                x = x.parent;
            }
            return x.parent;
            
        } else {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }
    }
}