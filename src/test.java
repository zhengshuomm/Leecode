import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		 Set<List<Node>> res= new HashSet<List<Node>>();
		 List<Node> l1 = new ArrayList<>();
		 List<Node> l2 = new ArrayList<>();
		 l1.add(new Node(1));
		 l2.add(new Node(1));
		 res.add(l1);
		 res.add(l2);
		 System.out.println(l1.hashCode());
		 System.out.println(l2.hashCode());
		 System.out.println(res.size());
		 
	}
	
	static class Node {
		int a;
		public Node(int a) {
			this.a = a;
		}
	}
}
