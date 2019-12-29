/*Method 1 (Uses Parent Pointer) 
In this method, we assume that every node has parent pointer. 
The Algorithm is divided into two cases on the basis of right subtree of the input node being empty or not.
Input: node, root // node is the node whose Inorder successor is needed.
output: succ // succ is Inorder successor of node.
1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
Go to right subtree and return the node with minimum key value in right subtree.
2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
Travel up using the parent pointer until you see a node which is left child of it��s parent. The parent of such a node is the succ.*/

/*Method 2 (Don't Use Parent Pointer)
Inorder travel the tree and
1) If current visit node is target node,  mark the indicator as true.
2) If indicator is true, print the node and return.
*/
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root==null)
        return null;
 
    TreeNode next = null;
    TreeNode c = root;
    while(c!=null && c.val!=p.val){
        if(c.val > p.val){
            next = c;
            c = c.left;
        }else{
            c= c.right;
        }
    }
 
    if(c==null)        
        return null;
 
    if(c.right==null)
        return next;
 
    c = c.right;
    while(c.left!=null)
        c = c.left;
 
    return c;
}
