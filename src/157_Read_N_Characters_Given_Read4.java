
public class Read_N_Characters_Given_Read4_157 {
	 private int buffPtr = 0;
	    private int buffCnt = 0;
	    private char[] buff = new char[4];
	    public int read(char[] buf, int n) {
	        int ptr = 0;
	        while (ptr < n) {
	            buffCnt = read4(buff);
	            if (buffCnt == 0) break;
	            while (ptr < n && buffPtr < buffCnt) {
	                buf[ptr++] = buff[buffPtr++];
	            }
	            buffPtr = 0;
	        }
	        return ptr;
	    }
}
