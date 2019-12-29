//There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
//
//For each house i, we can either build a well inside it directly with cost wells[i], or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes, where each pipes[i] = [house1, house2, cost] represents the cost to connect house1 and house2 together using a pipe. Connections are bidirectional.
//
//Find the minimum total cost to supply water to all houses.


class Solution {
    
    int[] parent;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        parent = new int[++n]; 
        List<int[]> edges = new ArrayList<>();
        for (int[] pipe : pipes) {
            edges.add(pipe);
        }
        for (int i = 1; i < n; i++) {
            edges.add(new int[]{0, i, wells[i - 1]});
            parent[i] = i;
        }
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int ans = 0;
        for (int[] edge :edges) {
            // if (n == 1) break;
            int x = find(edge[0]);
            int y = find(edge[1]);
            if (x != y) {
                parent[x] = y;
                ans += edge[2];
            }
        }
        return ans;
    }

    private int find(int i) {
        if (parent[i] == i) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }
}