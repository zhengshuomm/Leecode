//Design a hit counter which counts the number of hits received in the past 5 minutes.
//
//Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
//
//It is possible that several hits arrive roughly at the same time.
public class Design_Hit_Counter_362 {
//	public:
//	    /** Initialize your data structure here. */
//	    HitCounter() {}
//	    
//	    /** Record a hit.
//	        @param timestamp - The current timestamp (in seconds granularity). */
//	    void hit(int timestamp) {
//	        q.push(timestamp);
//	    }
//	    
//	    /** Return the number of hits in the past 5 minutes.
//	        @param timestamp - The current timestamp (in seconds granularity). */
//	    int getHits(int timestamp) {
//	        while (!q.empty() && timestamp - q.front() >= 300) {
//	            q.pop();
//	        }
//	        return q.size();
//	    }
//
//	private:
//	    queue<int> q; 
	
	
	public:
	    /** Initialize your data structure here. */
	    HitCounter() {
	        times.resize(300);
	        hits.resize(300);
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    void hit(int timestamp) {
	        int idx = timestamp % 300;
	        if (times[idx] != timestamp) {
	            times[idx] = timestamp;
	            hits[idx] = 1;
	        } else {
	            ++hits[idx];
	        }
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    int getHits(int timestamp) {
	        int res = 0;
	        for (int i = 0; i < 300; ++i) {
	            if (timestamp - times[i] < 300) {
	                res += hits[i];
	            }
	        }
	        return res;
	    }

	private:
	    vector<int> times, hits;
}
