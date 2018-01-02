import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuessNumber {

	public static void main(String[] args) {
	    GuessNumber gn = new GuessNumber();
	    System.out.println(gn.sendAndReceive("start"));
	    System.out.println("Result: " + gn.guess());
	    System.out.println(gn.sendAndReceive("start"));
	    System.out.println("Result: " + gn.guess());
	    System.out.println(gn.sendAndReceive("start"));
	    System.out.println("Result: " + gn.guess());
	    System.out.println(gn.sendAndReceive("start"));
	    System.out.println("Result: " + gn.guess());

	}

	private int count = 0;
	  private List<Integer> target = new ArrayList<>();

	  // Simulation method, to generate or reset the random number, don't have to focus on it
	  public void reset() {
	    target.clear();
	    for (int i = 0; i < 4; ++i) {
	      target.add((int)(Math.random() * 6) + 1);
	    }
	    count = 0;
	  }

	  // Simulation method, don't have to focus it
	  public String sendAndReceive(String str) {
	    if (str.toLowerCase().equals("start")) {
	      reset();
	      return "Ready, target # is " + target.get(0) + target.get(1) + target.get(2) + target.get(3);
	    }
	    System.out.println("Times of method call: " + ++count + ", coming number: " + str);
	    int a = 0;
	    List<Integer> copyOfTarget = new ArrayList<>(target);
	    List<Integer> t = new ArrayList<>();
	    List<Integer> g = new ArrayList<>();

	    for (int i = 0; i < 4; ++i) {
	      int digit = copyOfTarget.get(i);
	      char c = str.charAt(i);

	      if (digit == c - '0') {
	        ++a;
	      } else {
	        t.add(digit);
	        g.add(c - '0');
	      }
	    }

	    int size = g.size();
	    g.removeAll(t);
	    int b = size - g.size();

	    return a + " " + b;
	  }

	  public String guess() {
	    String base = "1111";
	    int firstResp = Integer.parseInt(sendAndReceive(base).split(" ")[0]);
	    if (firstResp == 4) {
	      return base;
	    }

	    char[] res = new char[4];
	    Arrays.fill(res, '0');
	    for (int i = 0; i < 4; i++) {
	      int lastResp = firstResp;
	      char[] charBase = base.toCharArray();
	      for (int j = 2; j < 6; j++) {
	        charBase[i] = (char)('0' + j);
	        int resp = Integer.parseInt(sendAndReceive(new String(charBase)).split(" ")[0]);
	        if (resp == 4) {
	          return new String(charBase);
	        }
	        if (resp != lastResp) {
	          res[i] = lastResp > resp ? '1' : (char)('0' + j);
	          break;
	        }
	      }
	      if (res[i] == '0') {
	        res[i] = '6';
	      }
	    }

	    return new String(res);
	  }

}
