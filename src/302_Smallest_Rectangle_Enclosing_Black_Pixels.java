/*An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,*/
public class Smallest_Rectangle_Enclosing_Black_Pixels_302 {
	// solution 1
	private int top, bottom, left, right;
    public int minArea(char[][] image, int x, int y) {
        if(image.length == 0 || image[0].length == 0) return 0;
        top = bottom = x;
        left = right = y;
        dfs(image, x, y);
        return (right - left) * (bottom - top);
    }
    private void dfs(char[][] image, int x, int y){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length ||
          image[x][y] == '0')
            return;
        image[x][y] = '0'; // mark visited black pixel as white
        top = Math.min(top, x);
        bottom = Math.max(bottom, x + 1);
        left = Math.min(left, y);
        right = Math.max(right, y + 1);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }
    
    
    
    
	// solution 2
	public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0) {
            return 0;
        }
        int rowNum = image.length, colNum = image[0].length;
        int left = binarySearch(image, 0, y, 0, rowNum, true, true);
        int right = binarySearch(image, y + 1, colNum, 0, rowNum, true, false);
        int top = binarySearch(image, 0, x, left, right, false, true);
        int bot = binarySearch(image, x + 1, rowNum, left, right, false, false);
        
        return (right - left) * (bot - top);
    }
    
    private int binarySearch(char[][] image, int lo, int hi, int min, int max, boolean searchHorizontal, boolean searchLo) {
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean hasBlackPixel = false;
            for(int i = min; i < max; i++) {
                if((searchHorizontal ? image[i][mid] : image[mid][i]) == '1') {
                    hasBlackPixel = true;
                    break;
                }
            }
            if(hasBlackPixel == searchLo) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
