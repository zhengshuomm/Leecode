import java.util.List;

/*Implement an iterator to flatten a 2d vector.

For example,

Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].*/
public class Flatten_2D_Vector_251 {
	 List<Integer> ans;
	    int index;
	    public Vector2D(int[][] v) {
	        ans = new ArrayList<>();
	        index = 0;
	        for (int i = 0; i < v.length; i++){
	            int[] temp = v[i];
	            for (int j = 0; j < temp.length; j++){
	                ans.add(temp[j]);
	            }
	        }
	        
	    }
	    
	    public int next() {
	        if (hasNext()){
	            return ans.get(index++);
	        }
	        return -1;
	        
	    }
	    
	    public boolean hasNext() {
	        return index < ans.size();
	        
	    }
	    
	    
	    // �μ�deep iterator
//	    http://www.mitbbs.com/article_t/JobHunting/32583985.html
}
