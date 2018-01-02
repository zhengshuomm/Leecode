import java.util.ArrayList;
import java.util.List;

public class Queue_with_Fixed_Array {
	private int fixedSize;
	private int head;
	private int tail;
	private List<Object> headList;
	private List<Object> tailList;
	private int count;
	
	public Queue_with_Fixed_Array(int fixedSize) {
		this.fixedSize = fixedSize;
		this.head = 0;
		this.tail = 0;
		this.headList = new ArrayList<>();
		this.tailList = this.headList;
		this.count = 0;
	}
	
	public void offer(int num) {
		if (tail == fixedSize - 1) {
			List<Object> newList = new ArrayList<>();
			newList.add(num);
			tailList.add(newList);
			tailList = (List<Object>) tailList.get(tail);
			tail = 0;
		} else {
			tailList.add(num);
		}
		count ++;
		tail ++;
	}
	
	public Integer poll() {
		if (count == 0) return null;
		int num = (Integer) headList.get(head);
		head ++;
		count --;
		
		if (head == fixedSize - 1) {
			List<Object> newList = (List<Object>) headList.get(head);
			headList.clear();
			headList = newList;
			head = 0;
		}
		return num;
		
	}
}
