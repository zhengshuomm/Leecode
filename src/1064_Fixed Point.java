//Given an array A of distinct integers sorted in ascending order, return the smallest index i that satisfies A[i] == i.  Return -1 if no such i exists.
//Input: [-10,-5,0,3,7]
//Output: 3
//Explanation: 
//For the given array, A[0] = -10, A[1] = -5, A[2] = 0, A[3] = 3, thus the output is 3.
class Solution {
    public int fixedPoint(int[] A) {
        int n=A.length;
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            if(A[i]==i)
                list.add(i);
        }
        
        int n1=list.size();
        if(n1==0)
            return -1;
        else
            return list.get(0);
    }
}