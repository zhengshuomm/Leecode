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
        Node newNode = new Node(insertVal);

        // 空链表：创建一个单节点自环
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;

        while (true) {
            // 1. 插入在升序中间
            if (prev.val <= insertVal && insertVal <= curr.val) {
                break;
            }

            // 2. 断点处（最大 -> 最小）
            if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    break;
                }
            }

            prev = curr;
            curr = curr.next;

            // 3. 全都一样，或绕了一圈没找到合适点
            if (prev == head) {
                break;
            }
        }

        // 插入节点
        prev.next = newNode;
        newNode.next = curr;
        return head;
    }
}