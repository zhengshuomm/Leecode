
public class Number_of_Islands_II_305 {
    private int[] islands;  
    private int root(int island) {  
        while (islands[island] != island) {  
            islands[island] = islands[islands[island]];  
            island = islands[island];  
        }  
        return island;  
    }  
    private int[] yo = {-1, 1, 0, 0};  
    private int[] xo = {0, 0, -1, 1};  
    public List<Integer> numIslands2(int m, int n, int[][] positions) {  
        islands = new int[m*n];  
        Arrays.fill(islands, -1);  
        int island = 0;  
        List<Integer> nums = new ArrayList<>();  
        for(int i=0; i<positions.length; i++) {  
            int y =positions[i][0];  
            int x = positions[i][1];  
            int id=y*n+x;  
            islands[id] = id;  
            island ++;  
            for(int j=0; j<4; j++) {  
                int ny = y+yo[j];  
                int nx = x+xo[j];  
                int nid=ny*n+nx;  
                if (ny>=0 && ny<m && nx>=0 && nx<n && islands[nid] != -1) {  
                    int root = root(nid);  
                    if (root != id) {  
                        islands[root] = id;  
                        island --;  
                    }  
                }  
            }  
            nums.add(island);  
        }  
        return nums;  
    }  
}
