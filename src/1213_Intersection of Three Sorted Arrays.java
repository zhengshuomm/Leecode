//Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
//Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
//Output: [1,5]
//Explanation: Only 1 and 5 appeared in the three arrays.

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        //for result
        List<Integer> res = new ArrayList();
        //base case
        if (arr1.length == 0 || arr2.length == 0 || arr3.length == 0) return res;
        //pointers for arrays
        int p1 = 0; int p2 = 0; int p3 = 0;
        //keep going while there is still stuff to compare
        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            //first, check if they're equal, if not, just move smallest pointer forward
            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                //add to result, its in all three
                res.add(arr1[p1]);
                //move all three pointers forward
                p1++; p2++; p3++;
            } else if (arr1[p1] <= arr2[p2] && arr1[p1] <= arr3[p3]) {
                //move first pointer forward
                p1++;
            } else if (arr2[p2] <= arr1[p1] && arr2[p2] <= arr3[p3]) {
                //move second pointer forward
                p2++;
            } else if (arr3[p3] <= arr2[p2] && arr3[p3] <= arr2[p2]) {
                //move third pointer forward
                p3++;
            }
        }

        return res;
    }
}