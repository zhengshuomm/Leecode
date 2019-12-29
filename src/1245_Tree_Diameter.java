//Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.
//
//The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v.  Each node has labels in the set {0, 1, ..., edges.length}.
//Input: edges = [[0,1],[0,2]]
//Output: 2
//Explanation: 
//A longest path of the tree is the path 1 - 0 - 2.

class Solution {
    Map<Integer, List<Integer>> graph;
    int maxDiameter = 0; 
    
    private int diameter(int curr, boolean[] visited) {
        if(visited[curr]) return 0; 
        visited[curr] = true; 
        int max1 = 0, max2 = 0; 
        for(int neighbor : graph.get(curr)) {
            int m = diameter(neighbor, visited); 
            if(m > max1) {
                max2 = max1; 
                max1 = m; 
            } else if(m > max2) {
                max2 = m; 
            }
        }
        visited[curr] = false; 
        maxDiameter = Math.max(maxDiameter, 1 + max1 + max2);
        return max1+1; 
    }
    
    public int treeDiameter(int[][] edges) {
        if(edges.length == 0) return 0;
        graph = new HashMap<>(); 
        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<Integer>());
            graph.putIfAbsent(edge[1], new ArrayList<Integer>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[graph.size()];
        diameter(0, visited); 
        return maxDiameter-1;
    }
}