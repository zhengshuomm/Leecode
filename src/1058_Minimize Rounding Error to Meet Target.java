//Input: prices = ["0.700","2.800","4.900"], target = 8
//Output: "1.000"
//Explanation: 
//Use Floor, Ceil and Ceil operations to get (0.7 - 0) + (3 - 2.8) + (5 - 4.9) = 0.7 + 0.2 + 0.1 = 1.0 .

class Solution {
    private static DecimalFormat df = new DecimalFormat("0.000");
    public String minimizeError(String[] prices, int target) {
        if (prices.length == 0) return "-1";
        int sum = 0;
        List<Cell> list = new ArrayList<Cell>();
        for (String price: prices) {
            double n = Double.parseDouble(price);
            int floor = (int)n;
            int ceil = (int)Math.ceil(n);
            sum += floor;
            list.add(new Cell(ceil, n, ceil-n));
        }
        double result = 0;
        int diff = target - sum;
         // System.out.println(diff);
        Collections.sort(list);
        for (int i = 0 ; i < list.size() ;i  ++) {
            
            Cell cell = list.get(i);
            // System.out.println(cell.num);
            if (diff > 0 && cell.diff > 0.00001) {
                result += cell.diff;
                diff --;
            } else {
                result += cell.num - (int)cell.num;   
            }
        }
        System.out.println(result);
        if (diff != 0) return "-1";
        // result = Math.round(result * 1000) / 1000;
        return df.format(result);
    }
    
    
    class Cell implements Comparable<Cell>{
        int ceil;
        double num;
        double diff;
        public Cell(int ceil, double num, double diff){
            this.ceil = ceil;
            this.num = num;
            this.diff = diff;
        }
        
        public int compareTo(Cell that){
            if (this.diff - that.diff < 0.00001) return -1;
            else return 1;
        }
    }
}