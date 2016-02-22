/**
 * @see <a href="https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/">Read N Characters Given Read4 II - Call multiple times</a>
 */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public char[] remain = new char[0];
    public int read(char[] buf, int n) {
        // notice that, the buf variable is not created within the function,
        // it is provided by the caller.
        if (n <= 0) return 0;
        if (n <=  remain.length) {
            int i = 0;
            int j = 0;
            for (; j < n; ++j, ++i) {
                buf[i] = remain[j];
            }
            remain = Arrays.copyOfRange(remain, n, remain.length); 
            return n;
        }
        else {// n > remain.length
            int totalCount = 0;
            int bufi = 0;
            if (remain.length != 0) {

                int remaini = 0;
                // read the remaining.
                for ( ; remaini < remain.length; ++remaini) {
                    buf[bufi] = remain[remaini];
                    ++bufi;
                }
		n = n - remain.length;
                totalCount += remain.length;
                remain = new char[0];
            }
            
            while (n > 0) {
                char[] tempBuf = new char[4];
                int read = read4(tempBuf);

                int count = Math.min(n, read);
                totalCount += count;
                for (int i = 0; i < count; ++i) {
                    buf[bufi] = tempBuf[i];
                    ++bufi;
                }
                if (read > count) {
                    char[] newRemain = new char[read - count];
                    int newRemaini = 0;
                    for (int i = count; i < read; ++i) {
                        newRemain[newRemaini] = tempBuf[i];
                        ++newRemaini;
                    }
                    remain = newRemain;
                }
                n = n - Math.min(n, read);
                if (read < 4) break; // reached end of file.
            }
            
            return totalCount;
        }
    }
}
