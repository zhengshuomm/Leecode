//Assume you have an array of length n initialized with all 0's and are given k update operations.
//
//Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
//
//Return the modified array after all k operations were executed.
//http://www.cnblogs.com/grandyang/p/5628786.html
public class Range_Addition_370 {
    vector<int> getModifiedArray(int length, vector<vector<int>>& updates) {
        vector<int> res, nums(length + 1, 0);
        for (int i = 0; i < updates.size(); ++i) {
            nums[updates[i][0]] += updates[i][2];
            nums[updates[i][1] + 1] -= updates[i][2];
        }
        int sum = 0;
        for (int i = 0; i < length; ++i) {
            sum += nums[i];
            res.push_back(sum);
        }
        return res;
    }
}
