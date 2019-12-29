/*You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.*/
public class Shortest_Distance_from_All_Buildings_317 {
	    static class point {
	        int x;
	        int y;
	        public point(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	    }
	    public int shortestDistance(int[][] grid) {
	        if (grid == null || grid.length == 0) {
	            return 0;
	        }
	        int m = grid.length;
	        int n = grid[0].length;
	        int[][] distance = new int[m][n];
	        int[][] reach = new int[m][n];
	        
	        int numberOfBuildings = 0;
	        for (int i = 0; i < m; i ++) {
	            for (int j = 0; j < n; j ++) {
	                if (grid[i][j] == 1) {
	                    boolean[][] visited = new boolean[m][n];
	                    Queue<point> queue = new LinkedList<point>();
	                    helper(i, j, grid, visited, distance, reach, 0, queue);
	                    numberOfBuildings ++;
	                }
	            }
	        }
	        int minDistance = Integer.MAX_VALUE;
	        for (int i = 0; i < m; i ++) {
	            for (int j = 0; j < n; j ++) {
	                if (grid[i][j] == 0) {
	                    if (reach[i][j] == numberOfBuildings)
	                        minDistance = Math.min(minDistance, distance[i][j]);
	                }
	            }
	        }
	        if (minDistance == Integer.MAX_VALUE) {
	            return -1;
	        } 
	        return minDistance;
	        
	    }
	    
	    public void helper(int x, int y, int[][] grid, boolean[][] visited, int[][] distance, int[][] reach, int currentDistance, Queue<point> queue) {
	        fillPoint(x ,y, x, y, grid, visited, distance, reach, currentDistance, queue);
	        
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            currentDistance ++;
	            for(int i = 0; i < size; i ++) {
	                point p = queue.poll();
	                int newX = p.x;
	                int newY = p.y;
	                fillPoint(x, y, newX + 1, newY, grid, visited, distance, reach, currentDistance, queue);
	                fillPoint(x, y, newX - 1, newY, grid, visited, distance, reach, currentDistance, queue);
	                fillPoint(x, y, newX, newY + 1, grid, visited, distance, reach, currentDistance, queue);
	                fillPoint(x, y, newX, newY - 1, grid, visited, distance, reach, currentDistance, queue);
	            }
	        }
	    }
	    
	    public void fillPoint(int originalX, int originalY, int x, int y, int[][] grid, boolean[][] visited, int[][] distance, int[][] reach, int currentDistance, Queue<point> queue) {
	        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
	            return;
	        }
	        if ((x != originalX || y != originalY) && grid[x][y] !=0) {
	            return;
	        }
	        visited[x][y] = true;
	        distance[x][y] += currentDistance;
	        reach[x][y] ++;
	        queue.offer(new point(x,y));
	    }

}
