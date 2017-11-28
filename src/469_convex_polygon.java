//Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).
//
//Note:
//
//There are at least 3 and at most 10,000 points.
//Coordinates are in the range -10,000 to 10,000.
//You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
public class convex_polygon_469 {
	
    bool isConvex(vector<vector<int>>& points) {
        long long n = points.size(), pre = 0, cur = 0;
        for (int i = 0; i < n; ++i) {
            int dx1 = points[(i + 1) % n][0] - points[i][0];
            int dx2 = points[(i + 2) % n][0] - points[i][0];
            int dy1 = points[(i + 1) % n][1] - points[i][1];
            int dy2 = points[(i + 2) % n][1] - points[i][1];
            cur = dx1 * dy2 - dx2 * dy1;
            // cross product is 0 means three points one the same line.
            if (cur != 0) {
                if (cur * pre < 0) return false;
                else pre = cur;
            }
        }
        return true;
    }
}
