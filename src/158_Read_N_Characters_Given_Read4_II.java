
public class Read_N_Characters_Given_Read4_II_158 {
	/**
	       * @param buf Destination buffer
	       * @param n   Maximum number of characters to read
	       * @return    The number of characters read
	       */
	     /* private char[] buffer = new char[4];
	      private int oneRead = 0;   // have how many byte left
	      private int offset = 0;    // next time, should locate where to find the buffer
	      
	      public int read(char[] buf, int n) {
	          boolean eof = false;
	          int haveRead = 0;
	          while (!eof && haveRead < n) {
	              if (oneRead == 0) {
	                  oneRead = read4(buffer);
	                  eof = oneRead < 4;
	              }
	              int actRead = Math.min(n-haveRead, oneRead);
	              for (int i=0; i<actRead; i++) {
	                  buf[haveRead+i] = buffer[offset+i];
	              }
	              oneRead -= actRead;
	              offset = (offset + actRead) % 4;
	              haveRead += actRead;
	          }
	          return haveRead;
	      } */
}
