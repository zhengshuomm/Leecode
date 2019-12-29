//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
//
//Example 1:
//
//     0          3
//
//     |          |
//
//     1 --- 2    4
//
//Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
//
//Example 2:
//
//     0           4
//
//     |           |
//
//     1 --- 2 --- 3
//
//Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
//
// Note:
//
//You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
public class Number_of_Connected_Components_in_an_Undirected_Graph_323 {
	 public int countComponents(int n, int[][] edges) {
	        int res = n;
	        int[] root = new int[n];
	        for (int i = 0; i < n; ++i) root[i] = i;
	        for (int[] e : edges) {
	            int x = find(root, e[0]), y = find(root, e[1]);
	            if (x != y) {
	                --res;
	                root[y] = x;
	            }
	        }
	        return res;
	    }
	    
	    int find(int[] root, int i) {
	        while (root[i] != i) i = root[i];
	        return i;
	    }
}
