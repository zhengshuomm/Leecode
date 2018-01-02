import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class WizardShortDistance {
	public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
		if (wizards == null || wizards.size() == 0)
			return null;
		int n = wizards.size();
		int[] parent = new int[n];
		Map<Integer, Wizard> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			map.put(i, new Wizard(i));
		}
		map.get(source).dist = 0;
		Queue<Wizard> pq = new PriorityQueue<>(n);
		pq.offer(map.get(source));
		while (!pq.isEmpty()) {
			Wizard curr = pq.poll();
			List<Integer> neighbors = wizards.get(curr.id);
			for (int neighbor : neighbors) {
				Wizard next = map.get(neighbor);
				int weight = (int) Math.pow(next.id - curr.id, 2);
				if (curr.dist + weight < next.dist) {
					parent[next.id] = curr.id;
					pq.remove(next);
					next.dist = curr.dist + weight;
					pq.offer(next);
				}
			}
		}
		List<Integer> path = new ArrayList<>();
		int t = target;
		while (t != source) {
			path.add(t);
			t = parent[t];
		}
		path.add(source);
		Collections.reverse(path);
		return path;
	}

	class Wizard implements Comparable<Wizard> {
		int id;
		int dist;

		Wizard(int id) {
			this.id = id;
			this.dist = Integer.MAX_VALUE;
		}

		@Override
		public int compareTo(Wizard that) {
			return this.dist - that.dist;
		}
	}
}
