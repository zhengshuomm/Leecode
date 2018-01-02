import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// OA
public class Display_Pagination {
	public List<String> displayPages(List<String> input, int pageSize) {
		List<String> res = new ArrayList<>();
		if (input == null || input.size() == 0) {
			return res;
		}
		List<String> visited = new ArrayList<>();
		Iterator<String> iter = input.iterator();
		boolean reachEnd = false;
		while (iter.hasNext()) {
			String curr = iter.next();
			String hostId = curr.split(",")[0];
			if (!visited.contains(hostId) || reachEnd) {
				res.add(curr);
				visited.add(hostId);
				iter.remove();
			}
			if (visited.size() == pageSize) {
				visited.clear();
				reachEnd = false;
				if (!input.isEmpty()) {
					res.add(" ");
				}
				iter = input.iterator();
			}
			if (!iter.hasNext()) {
				iter = input.iterator();
				reachEnd = true;
			}
		}
		return res;
	}

	// Prefer this one.
	public List<String> displayPages2(List<String> input, int pageSize) {
		List<String> res = new ArrayList<>();
		Iterator<String> iter = input.iterator();
		Set<String> set = new HashSet<>();
		boolean reachEnd = false;
		int counter = 0;
		while (iter.hasNext()) {
			String cur = iter.next();
			String id = (cur.split(","))[0];
			if (!set.contains(id) || reachEnd) {
				res.add(cur);
				set.add(id);
				iter.remove();
				counter++;
			}
			if (counter == pageSize) {
				if (!input.isEmpty())
					res.add(" ");
				set.clear();
				counter = 0;
				reachEnd = false;
				iter = input.iterator();
			}
			if (!iter.hasNext()) {
				reachEnd = true;
				iter = input.iterator();
			}
		}
		return res;
	}
}
