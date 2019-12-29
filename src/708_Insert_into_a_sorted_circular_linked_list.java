/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node n = new Node(insertVal, null);
            n.next = n;
            return n;
        }
        Node temp = head, maxNode = null;
        int max = 0;
        while (temp != maxNode) {
            if (temp.val <= insertVal && temp.next.val >= insertVal) {
                temp.next = new Node(insertVal, temp.next);
                return head;
            }
            // 考虑相等的情况temp.next.val < temp.val
            if(max < temp.val || temp.next.val < temp.val){
                max = temp.val;
                maxNode = temp;
            }
            temp = temp.next;
        }
        // 插入的是一个最小值 或者是最大值
        temp.next = new Node(insertVal, temp.next);
        return head;
    }
}