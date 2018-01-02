import java.util.Arrays;

/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.*/
public class Meeting_Rooms_II_253 {
	// 经典题目，拆分start and end time.
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		int len = intervals.length;
		int[] startTime = new int[len];
		int[] endTime = new int[len];

		for (int i = 0; i < len; i++) {
			Interval curr = intervals[i];
			startTime[i] = curr.start;
			endTime[i] = curr.end;
		}

		// Sort the start and end time
		Arrays.sort(startTime);
		Arrays.sort(endTime);

		int activeMeetings = 0;
		int numMeetingRooms = 0;

		int i = 0;
		int j = 0;

		while (i < len && j < len) {
			if (startTime[i] < endTime[j]) {
				activeMeetings++;
				numMeetingRooms = Math.max(numMeetingRooms, activeMeetings);
				i++;
			} else {
				activeMeetings--;
				j++;
			}
		}

		return numMeetingRooms;
	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}

public int minMeetingRooms(Interval[] intervals) {
    if(intervals==null||intervals.length==0)
        return 0;
 
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            return i1.start-i2.start;
        }
    });
 
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int count=1;
    queue.offer(intervals[0].end);
 
    for(int i=1; i<intervals.length; i++){
        if(intervals[i].start<queue.peek()){
            count++;
 
        }else{
            queue.poll();
        }
 
        queue.offer(intervals[i].end);
    }
 
    return count;
}
