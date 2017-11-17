//Design a Phone Directory which supports the following operations:
//
// 
//
//get: Provide a number which is not assigned to anyone.
//check: Check if a number is available or not.
//release: Recycle or release a number.
public class Design_Phone_Directory_379 {
	Set<Integer> used = new HashSet<Integer>();
    Queue<Integer> available = new LinkedList<Integer>();
    int max;
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            available.offer(i);
        }
    }
    
    public int get() {
        Integer ret = available.poll();
        if (ret == null) {
            return -1;
        }
        used.add(ret);
        return ret;
    }
    
    public boolean check(int number) {
        if (number >= max || number < 0) {
            return false;
        }
        return !used.contains(number);
    }
    
    public void release(int number) {
        if (used.remove(number)) {
            available.offer(number);
        }
    }
}
