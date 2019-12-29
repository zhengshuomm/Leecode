import java.util.LinkedList;

public class Verify_preorder_sequence_in_BST_255 {
	 public static void main(String[] args) {
		int[] preorder = {0, 2, 3};
		System.out.println(verifyPreorder(preorder));
	}
	
	 public static boolean verifyPreorder(int[] preorder) {  
	        if (preorder == null || preorder.length == 0) return true;  
	        LinkedList<Integer> stack = new LinkedList<Integer>();  
	        int low = Integer.MIN_VALUE;  
	        for (int i = 0; i < preorder.length; i++) {  
	            if (preorder[i] < low) return false;  
	            while (!stack.isEmpty() && preorder[i] > stack.peek()) {  
	                low = stack.pop();  
	            }  
	            stack.push(preorder[i]);  
	        } 
	        return !stack.isEmpty();
	    }  
	      
	    // Method 1: brute force  
	    public boolean verifyPreorder1(int[] preorder) {  
	        if (preorder == null) return false;  
	        return recur(preorder, 0, preorder.length - 1);  
	    }  
	    public boolean recur(int[] preorder, int start, int end) {  
	        if (start >= end) return true;  
	        int i = start + 1;  
	        while (i <= end && preorder[i] < preorder[start])  
	            i++;  
	        if (!recur(preorder, start + 1, i - 1))  
	            return false;  
	        int rightStart = i;  
	        while (i <= end && preorder[i] > preorder[start])  
	            i++;  
	        if (i <= end) return false;  
	        return recur(preorder, rightStart, end);  
	    }  
}
