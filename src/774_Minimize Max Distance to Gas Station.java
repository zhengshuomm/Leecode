//https://blog.csdn.net/magicbean2/article/details/79663323

//On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.
//
//Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.
//
//Return the smallest possible value of D.
//
//Example:
//
//Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
//Output: 0.500000


1、采用优先队列：采用优先队列的思路比较简单：就是每次找出gap最大的一个区间，然后新加入一个station，直到所有的k个station都被加入，此时最大的gap即为所求。在实现上我们采用优先队列，使得每次最大的gap总是出现在队首。这种方法的空间复杂度是O(n)，时间复杂度是O(klogn)，其中k是要加入的新station的个数，n是原有的station个数。这种方法应该没毛病，但是还是没有通过所有的数据测试。

2、采用二分查找：在网上参考了采用二分查找的实现。我们容易得知，minmaxGap的最小值left = 0，最大值right = stations[n - 1] - stations[0]。我们每次取mid为left和right的均值，然后计算如果mimaxGap为mid，那么最少需要添加多少个新的stations，记为count。所以如果count > K，说明均值mid选取的过小，使得我们必须新加更多的stations才能满足要求，所以我们就更新left的值；否则说明均值mid选取的过大，使得我们需要小于K个新的stations就可以达到要求，那么我们此时就可以寻找更小的mid，使得count增加到K。如果我们假设stations[N - 1] - stations[0] = m，那么这种实现的空间复杂度是O(1)，时间复杂度是O(nlogm)，可以发现与k无关了。


class Solution {
public:
    double minmaxGasDist(vector<int>& stations, int K) {
        priority_queue<vector<double>> pq;     // {avg_distance, count}
        for (int i = 0; i + 1 < stations.size(); ++i) {
            pq.push({stations[i + 1] - stations[i], 1});
        }
        for (int i = 0; i < K; ++i) {
            vector<double> vec = pq.top();
            pq.pop();
            vec[0] = vec[0] * vec[1] / (vec[1] + 1);
            vec[1] += 1.0;
            pq.push(vec);
        }
        return pq.top()[0];
    }
};



class Solution {
public:
    double minmaxGasDist(vector<int>& stations, int K) {
        int count, N = stations.size();
        double left = 0, right = stations[N - 1] - stations[0], mid;
        while (left + 1e-6 < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i) {
                count += ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if (count > K) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return right;
    }
};
