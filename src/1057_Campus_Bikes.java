//On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
//
//Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the bike to that worker. (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index). We repeat this process until there are no available workers.
//
//The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
//
//Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int N = workers.length;
        int M = bikes.length;
        int[][] pair = new int[N * M][3];
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < M; ++j)
            {
                int[] c = pair[i*M+j];
                c[0] = i;
                c[1] = j;
                c[2] = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
            }
        }
        
        Arrays.sort(pair, (a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int i = 0;
        int[] result = new int[N];
        Arrays.fill(result, -1);
        Set<Integer> used_bikes = new HashSet();
        while (used_bikes.size() < N)
        {
            int[] c = pair[i++];
            if (result[c[0]] == -1 && !used_bikes.contains(c[1]))
            {
                result[c[0]] = c[1];
                used_bikes.add(c[1]);
            }
        }
        
        return result;
    }
}