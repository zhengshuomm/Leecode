import java.util.ArrayList;
import java.util.List;

public class Factor_Combinations_254 {
	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> seq = new ArrayList<Integer>();
		factors(8, 0, result, seq, 2);
		System.out.println(result);
		
	}
	
	public static void factors(int n, int cur, List<List<Integer>> result, List<Integer> seq, int start){
		if (n == 1 && seq.size() != 1){
			result.add(new ArrayList<Integer>(seq));
			return;
		}
		
		for (int i = start ; i <= n ; i ++){
			if (n % i == 0){
				seq.add(i);
				factors(n / i , cur, result, seq, i);
				seq.remove(seq.size() - 1);
			}
		}
	}
}
