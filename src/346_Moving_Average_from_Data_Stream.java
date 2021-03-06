//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
public class Moving_Average_from_Data_Stream_346 {
	  int size, windowSum = 0, count = 0;
	  Deque queue = new ArrayDeque<Integer>();
	    
	  public MovingAverage(int size) {
	    this.size = size;
	  }

	  public double next(int val) {
	    ++count;
	    // calculate the new sum by shifting the window
	    queue.add(val);
	    int tail = count > size ? (int)queue.poll() : 0;
	     
	    windowSum = windowSum - tail + val;

	    return windowSum * 1.0 / Math.min(size, count);
	  }
}
