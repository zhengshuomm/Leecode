//Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
//
//The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
//
//next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
//hasNext() - Judge whether there is any letter needs to be uncompressed.
//
//Note:
//Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.
//
//Example:
//
//StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
//
//iterator.next(); // return 'L'
//iterator.next(); // return 'e'
//iterator.next(); // return 'e'
//iterator.next(); // return 't'
//iterator.next(); // return 'C'
//iterator.next(); // return 'o'
//iterator.next(); // return 'd'
//iterator.hasNext(); // return true
//iterator.next(); // return 'e'
//iterator.hasNext(); // return false
//iterator.next(); // return ' '
public class Design_Compressed_String_Iterator_604 {
    Queue<int[]> queue = new LinkedList<>();
    
    public StringIterator(String s) {
        int i = 0, n = s.length();
        while (i < n) {
            int j = i+1;
            while (j < n && s.charAt(j) - 'A' < 0) j++;
            queue.add(new int[]{s.charAt(i) - 'A',  Integer.parseInt(s.substring(i+1, j))});
            i = j;
        }
    }
    
    public char next() {
        if (queue.isEmpty()) return ' ';
        int[] top = queue.peek();
        if (--top[1] == 0) queue.poll();
        return (char) ('A' + top[0]);
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
