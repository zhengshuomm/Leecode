//Given a grid where each entry is only 0 or 1, find the number of corner rectangles.
//
//A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
//
// Example 1:
//
//Input: grid = 
//[[1, 0, 0, 1, 0],
// [0, 0, 1, 0, 1],
// [0, 0, 0, 1, 0],
// [1, 0, 1, 0, 1]]
//Output: 1
//Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].



//https://blog.csdn.net/magicbean2/article/details/79552547
//开始的时候被误导了，觉得用DP是正路，但是后来发现其实用枚举的时间复杂度和空间复杂度反而更低：我们枚举任意两行r1和r2，看这两行中存在多少列，满足在该列中第r1行和第r2行中对应的元素都是1。假设有counter列满足条件，那么这两行可以构成的的recangles的数量就是counter * (counter - 1) / 2。最后返回所有rectangles的数量即可。
//
//如果我们假设grid一共有m行n列，那么算法的时间复杂度就是O(m^2n)，空间复杂度是O(1)。当然如果m远大于n的时候，我们还可以将时间复杂度优化到O(mn^2)。
// ———————————————— 
class Solution {
public:
    int countCornerRectangles(vector<vector<int>>& grid) {
        int ans = 0;
        for (int r1 = 0; r1 + 1 < grid.size(); ++r1) {
            for (int r2 = r1 + 1; r2 < grid.size(); ++r2) {
                int counter = 0;
                for (int c = 0; c < grid[0].size(); ++c) {
                    if (grid[r1][c] == 1 && grid[r2][c] == 1) {
                        ++counter;
                    }
                }
                ans += counter * (counter - 1) / 2;
            }
        }
        return ans;
    }
}
