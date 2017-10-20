
public class ReadN {
	
//	private char[] buffer = new char[4];
//    private int oneRead = 0;   // have how many byte left
//    private int offset = 0;    // next time, should locate where to find the buffer
//    
//    public int read(char[] buf, int n) {
//    	boolean eof = false;
//    	int haveRead = 0;
//    	while (haveRead < n && !eof){
//    		if (oneRead == 0){
//    			oneRead = read4(buffer);
//    			eof = oneRead < 4;
//    		}
//    		
//    		int actRead = Math.min(n - haveRead, oneRead);
//    		for (int i = 0 ; i < actRead ; i ++){
//    			buf[haveRead + i] = buffer[i + offset];
//    		}
//    		oneRead -= actRead;
//    		offset += actRead % 4;
//    		haveRead += actRead;
//    	}
//    	return haveRead;
//    }
//    
}
