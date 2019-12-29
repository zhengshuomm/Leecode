//On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
//
//We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their assigned bike is minimized.
//
//The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
//
//Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.

class Solution {
    int minSum=Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, 0, 0, new HashSet<Integer>());
        return minSum;
    }
    
    private void dfs(int[][] workers, int[][] bikes, int index, int sum, Set<Integer> visitedBike){
        if(index==workers.length){
            minSum=Math.min(minSum, sum);
            return;
        }
        if(sum>minSum){return;}
        for(int i=0; i<bikes.length; i++){
            if(visitedBike.contains(i)){continue;}
            visitedBike.add(i);
            int[] worker=workers[index];
            int[] bike=bikes[i];
            int dis=Math.abs(worker[0]-bike[0])+Math.abs(worker[1]-bike[1]);
            dfs(workers, bikes, index+1, sum+dis, visitedBike);
            visitedBike.remove(i);
        }
    }
}


class Solution {
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        return dfs(new HashMap<String, Integer>(), new boolean[bikes.length],0,workers,bikes,0);
        // return min;
    }
    
    int dfs(Map<String, Integer>dp ,boolean[] visited, int i, int[][] workers, int[][] bikes, int distance){
        String curr = Arrays.toString(visited);
        if (dp.containsKey(curr)) return dp.get(curr);
        // if (i==workers.length && distance < min) min = distance;
        if (i>=workers.length) return 0;
        // if (distance>min) return;
        int min=Integer.MAX_VALUE;
        for (int j=0; j<bikes.length; j++){
            if (visited[j]) continue;
            visited[j] = true;
            min = Math.min(min, dfs(dp, visited, i+1, workers, bikes, distance) + dis(i,j,workers,bikes));
            visited[j] = false;
        }
        dp.put(curr, min);
        return min;
    }
    
    int dis(int i, int j, int[][] workers, int[][] bikes){
        return Math.abs(workers[i][0]-bikes[j][0])+Math.abs(workers[i][1]-bikes[j][1]);
    }
}


