//A tree rooted at node 0 is given as follows:
//
//The number of nodes is nodes;
//The value of the i-th node is value[i];
//The parent of the i-th node is parent[i].
//Remove every subtree whose sum of values of nodes is zero.
//
//After doing so, return the number of nodes remaining in the tree.

//Input: nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
//Output: 2

class Solution {
    public int deleteTreeNodes(int n, int[] parent, int[] value) {
        int[] res = new int[n];
        for (int i = n - 1; i > 0; --i) {
            value[parent[i]] += value[i];
            res[parent[i]] += value[i] != 0 ? res[i] + 1 : 0;
        }
        return value[0] != 0 ? res[0] + 1 : 0;
    }
}