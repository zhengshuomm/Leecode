//Given a start IP address ip and a number of ips we need to cover n, return a representation of the range as a list (of smallest possible length) of CIDR blocks.
//
//A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example: "123.45.67.89/20". That prefix length "20" represents the number of common prefix bits in the specified range.
//
//Example 1:
//
//Input: ip = "255.0.0.7", n = 10
//Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
//Explanation:
//The initial ip address, when converted to binary, looks like this (spaces added for clarity):
//255.0.0.7 -> 11111111 00000000 00000000 00000111
//The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
//ie. just this one address.
//
//The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the given address:
//255.0.0.8 -> 11111111 00000000 00000000 00001000
//Addresses with common prefix of 29 bits are:
//11111111 00000000 00000000 00001000
//11111111 00000000 00000000 00001001
//11111111 00000000 00000000 00001010
//11111111 00000000 00000000 00001011
//11111111 00000000 00000000 00001100
//11111111 00000000 00000000 00001101
//11111111 00000000 00000000 00001110
//11111111 00000000 00000000 00001111
//
//The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the given address,
//ie. just 11111111 00000000 00000000 00010000.
//
//In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .
//
//There were other representations, such as:
//["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
//but our answer was the shortest possible.
//
//Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
//because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100 
//that are outside the specified range.
// ———————————————— 


//https://blog.csdn.net/qq_32832023/article/details/78891298
class Solution {
    public  List<String> ipToCIDR(java.lang.String ip, int range) {
        long x = 0;
        //获得一个ip地址每一部分
        String[] ips = ip.split("\\.");
        //将整ip地址看为一个整体，求出整体的int表示
        for (int i = 0; i < ips.length; ++i) {
            x = Integer.parseInt(ips[i]) + x * 256;
        }
        List<String> ans = new ArrayList<>();
        while (range > 0) {
            //求出二进制表示下的最低有效位的位数能表示的地址的数量
            //如果为奇数，则=1，即以原单个起始ip地址为第一块
            //如果为偶数，则二进制表示下的最低有效位的位数能表示的地址的数量
            long step = x & -x;
            //如果大于range，则需要缩小范围
            while (step > range) step /= 2;
            //不大于需要的range，开始处理
            //求出现在能表示的step个地址的地址块
            ans.add(longToIP(x, (int)step));
            //x加上以求出的地址块
            x += step;
            //range减去以表示的地址块
            range -= step;
        }//直到range<0
        return ans;
    }
    static String longToIP(long x, int step) {
        int[] ans = new int[4];
        //&255操作求出后8位十进制表示
        ans[0] = (int) (x & 255);
        //右移8位，即求下一个块
        x >>= 8;
        ans[1] = (int) (x & 255);
        x >>= 8;
        ans[2] = (int) (x & 255);
        x >>= 8;
        ans[3] = (int) x;
        int len = 33;
        //每一位就可以表示2个
        while (step > 0) {
            len --;
            step /= 2;
        }
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
    }
}

