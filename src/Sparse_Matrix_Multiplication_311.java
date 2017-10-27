/*Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.*/
public class Sparse_Matrix_Multiplication_311 {
	// http://www.cnblogs.com/grandyang/p/5282959.html
	public:
	    vector<vector<int>> multiply(vector<vector<int>>& A, vector<vector<int>>& B) {
	        vector<vector<int>> res(A.size(), vector<int>(B[0].size()));
	        for (int i = 0; i < A.size(); ++i) {
	            for (int k = 0; k < A[0].size(); ++k) {
	                if (A[i][k] != 0) {
	                    for (int j = 0; j < B[0].size(); ++j) {
	                        if (B[k][j] != 0) res[i][j] += A[i][k] * B[k][j];
	                    }
	                }
	            }
	        }
	        return res;
	    }
}
