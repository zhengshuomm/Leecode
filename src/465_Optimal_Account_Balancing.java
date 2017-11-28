//A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for 10.ThenlaterChrisgaveAlice5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
//
//Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
//
//Note:
//
//A transaction will be given as a tuple (x, y, z). Note that x ¡Ù y and z > 0.
//Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
public class Optimal_Account_Balancing_465 {
	public int minTransfers(int[][] transactions) {
		  Map<Integer, Long> map = new HashMap();
		  for(int[] t: transactions){
		    long val1 = map.getOrDefault(t[0], 0L);
		    long val2 = map.getOrDefault(t[1], 0L);
		    map.put(t[0], val1 - t[2]);
		    map.put(t[1], val2 + t[2]);
		  }        

		  List<Long> list = new ArrayList();
		  for(long val: map.values()){
		    if(val != 0) list.add(val);
		  }
		  
		  Long[] debts = new Long[list.size()];
		  debts = list.toArray(debts);
		  return helper(debts, 0 , 0);
		}

		int helper(Long[] debts, int pos, int count){
		  while(pos < debts.length && debts[pos] == 0) pos++;
		  int res = Integer.MAX_VALUE;
		  long pre = 0;
		  for(int i = pos + 1; i < debts.length; i++){
		    if(debts[i] != pre && debts[pos] * debts[i] < 0){
		      debts[i] += debts[pos];
		      res = Math.min(res, helper(debts, pos + 1, count + 1));
		      debts[i] = debts[i] - debts[pos];
		      pre = debts[i];
		    }
		  }
		  return res == Integer.MAX_VALUE ? count : res;
		}
}
