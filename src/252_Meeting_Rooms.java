/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,

Given [[0, 30],[5, 10],[15, 20]],
return false.*/
public class Meeting_Rooms_252 {
	// sort first and then determine whether the next start smaller than the current end.
	public boolean canAttendMeetings(int[][] intervals) {
	    Arrays.sort(intervals, new Comparator<int[]>() {
	        public int compare(int[] i1, int[] i2) {
	            return i1[0] - i2[0];
	        }        
	    });
	    for (int i = 0; i < intervals.length - 1; i++) {
	        if (intervals[i][1] > intervals[i + 1][0]) return false;
	    }
	    return true;
	}
}
