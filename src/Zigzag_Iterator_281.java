import java.util.List;

/*Given two 1d vectors, implement an iterator to return their elements alternately.
For example, given two 1d vectors:
v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?*/
public class Zigzag_Iterator_281 {
	
	// can use iterator and use a flag to denote which array should  iterator through,
	// this code is not good.
	private List<Integer> v1;
    private List<Integer> v2;
    private int i;
    private int j;
    private int listId;
 
    public Zigzag_Iterator_281(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.i = 0;
        this.j = 0;
        this.listId = 0;
    }
 
    public int next() {
        int result = 0;
        if (i >= v1.size()) {
            result = v2.get(j);
            j++;
        } else if (j >= v2.size()) {
            result = v1.get(i);
            i++;
        } else {
            if (listId == 0) {
                result = v1.get(i);
                i++;
                listId = 1;
            } else {
                result = v2.get(j);
                j++;
                listId = 0;
            }
        }
         
        return result;
    }
 
    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }
	
}
