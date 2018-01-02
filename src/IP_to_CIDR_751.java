Input: ip = "255.0.0.7", n = 10
Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
Explanation:
The initial ip address, when converted to binary, looks like this (spaces added for clarity):
255.0.0.7 -> 11111111 00000000 00000000 00000111
The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
ie. just this one address.

The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the given address:
255.0.0.8 -> 11111111 00000000 00000000 00001000
Addresses with common prefix of 29 bits are:
11111111 00000000 00000000 00001000
11111111 00000000 00000000 00001001
11111111 00000000 00000000 00001010
11111111 00000000 00000000 00001011
11111111 00000000 00000000 00001100
11111111 00000000 00000000 00001101
11111111 00000000 00000000 00001110
11111111 00000000 00000000 00001111

The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the given address,
ie. just 11111111 00000000 00000000 00010000.

In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .

There were other representations, such as:
["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
but our answer was the shortest possible.

Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100 
that are outside the specified range.
public class IP_to_CIDR_751 {
	public List<String> ipToCIDR(String ip, int range) {
		long x = 0;
		String[] ips = ip.split("\\.");
		for (int i = 0; i < ips.length; ++i) {
			x = Integer.parseInt(ips[i]) + x * 256;
		}
		
		List<String> ans = new ArrayList<>();
		while (range > 0) {
			long step = x & -x;
			while (step > range) step /= 2;    // 前log2(step) 步相同
			ans.add(longToIP(x, (int)step));
			x += step;
			range -= step;
		}
		
		return ans;
	}
	
	String longToIP(long x, int step) {
		int[] ans = new int[4];
		ans[0] = (int) (x & 255); x >>= 8;
		ans[1] = (int) (x & 255); x >>= 8;
		ans[2] = (int) (x & 255); x >>= 8;
		ans[3] = (int) x;
		int len = 33;
		while (step > 0) {
			len --;
			step /= 2;
		}
		return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
	}
}
