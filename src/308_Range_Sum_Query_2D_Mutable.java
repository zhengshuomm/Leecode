//Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
public class Range_Sum_Query_2D_Mutable_308 {
	int[][] tree;
    int[][] sums;
    int[][] matrix;
    int m,n;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.tree = new int[m + 1][n + 1];
        this.matrix = new int[m + 1][n + 1];
        // build tree
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    
    public void update(int row, int col, int val) {
        int gap = val - matrix[row + 1][col + 1];
        matrix[row + 1][col + 1] = val;
        for (int i = row + 1; i <= m; i += (i & -i)) {
            for (int j = col + 1; j <= n; j += (j & -j)) {
                tree[i][j] += gap;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2 + 1, col2 + 1) - getSum(row2 + 1, col1) - getSum(row1, col2 + 1) + getSum(row1, col1);
    }
    
    public int getSum(int r, int c) {
        int sum = 0;
        for (int i = r; i > 0; i -= (i & -i)) {
            for (int j = c; j > 0; j -= (j & -j)) {
                sum += tree[i][j];
            }
        }
        
        return sum;
    }
}

// http://www.cnblogs.com/grandyang/p/5300458.html
// ��άbinary index tree
