import java.util.PriorityQueue;

public class testPriorityQueue {
	public static void main(String[] args) {
		W a = new W(1);
		a.dist = 1;
		W b = new W(2);
		PriorityQueue<W> queue = new PriorityQueue<>();
		queue.add(a);
		queue.add(b);
		b.dist = 0;
		queue.remove(b);
		queue.add(b);
		while (!queue.isEmpty()) {
			System.out.println(queue.poll().id);
		}
	}

}

class W implements Comparable<W> {
	int id;
	int dist;

	W(int id) {
		this.id = id;
		this.dist = Integer.MAX_VALUE;
	}

	@Override
	public int compareTo(W that) {
		return this.dist - that.dist;
	}
}
