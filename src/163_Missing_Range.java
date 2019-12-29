import java.util.ArrayList;
import java.util.List;

public class Missing_Range_163 {

	// Given a sorted integer array where the range of elements are [0, 99]
	// inclusive, return its missing ranges.
	// For example, given [0, 1, 3, 50, 75], return [��2��, ��4->49��, ��51->74��,
	// ��76->99��]
	public class Solution {
		public List<String> findMissingRanges(int[] vals, int start, int end) {
			List<String> ranges = new ArrayList<String>();
            if (vals.length == 0) {
                ranges.add(getRange(start, end));
			    return ranges;
            }
            long prev = (long)start - 1;
			for (int i = 0; i <= vals.length; ++i) {
				long curr = (i == vals.length) ? (long)end + 1 : vals[i];
				if (curr == prev) continue;
                if (curr - prev != 1) {
					ranges.add(getRange( prev + 1, curr - 1));
				}
                System.out.println(curr);
				prev = curr;
			}
			return ranges;
		}

		private String getRange(long from, long to) {
			return (from == to) ? String.valueOf(from) : from + "->" + to;
		}  
}
