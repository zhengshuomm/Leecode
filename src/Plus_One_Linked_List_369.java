//Given a non-negative number represented as a singly linked list of digits, plus one to the number.
//
//The digits are stored such that the most significant digit is at the head of the list.
public class Plus_One_Linked_List_369 {
	// i is the last number that not equals to 9.
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        
        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        
        if (dummy.val == 0) {
            return dummy.next;
        }
        
        return dummy;
    }
}
