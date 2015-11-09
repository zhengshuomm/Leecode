import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.
Given n = 2, return ["11","69","88","96"].
*/
public class Strobogrammatic_Number_II_247 {
	public static void main(String[] args) {
		int n = 2; 
		System.out.println(findStrobogrammatic(n));
	}
	
	public static List<String> findStrobogrammatic(int n) { 
		List<String> original = Arrays.asList("");
		if (n % 2 == 1){
			original = Arrays.asList("0", "1", "8");
		}
		List<String> bases = Arrays.asList("00", "11", "88", "69", "96");
		int m = bases.size();
		while (n > 1){
			List<String> tmp = new ArrayList<>();
			for (String ss : original){
				for (int i = (n <= 2) ? 1 : 0 ; i < m ; i ++){
					tmp.add(bases.get(i).substring(0, 1) + ss + bases.get(i).substring(1));
				}
			}
			original = tmp;
			n -=2;
		}
		return original;
	}
}
