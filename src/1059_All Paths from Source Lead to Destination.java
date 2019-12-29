//Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
//Output: false
//Explanation: It is possible to reach and get stuck on both node 1 and node 2.
class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        LinkedList<Integer>[] adj = new LinkedList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new LinkedList<>();
        }
        for(int[] edge: edges){
            adj[edge[0]].offerLast(edge[1]);
        }
        boolean[] visited = new boolean[n];
        visited[source] = true;
        return dfs(source, destination, visited, adj);
    }
    
    private boolean dfs(int u, int d, boolean[] visited, LinkedList<Integer>[] adj){
        LinkedList<Integer> next = adj[u];
        // come to a dead point
        if(u != d && next.size() == 0){
            return false;
        }
        for(int v: next){
            // 有loop
            if(visited[v]){
                return false;
            }
            visited[v] = true;
            if(!dfs(v, d, visited, adj)){
                return false;
            }
            visited[v] = false;
        }
        return true;
    }
}