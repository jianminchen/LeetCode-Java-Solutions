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
     // not int, it is char !!!!!!!!!!!!!!!!!!!
    public char[] remain = new char[0];
    public int read(char[] buf, int n) {
        // notice that, the buf variable is not created within the function,
        // it is provided by the caller.
        if (n <= 0) return 0;
        if (n <=  remain.length) {
            int i = 0;
            int j = 0;
            // buf = Arrays.copyOf(remain, n); // copy into a new array, can we use like this????
            // after this, what will be the length of buf? buf is not a new array, it is provided by the outside caller?
            // can we modify it????
            // Don't modify buf !!!!!!!!!!!!
            for (; j < n; ++j, ++i) {
                buf[i] = remain[j];
            }
            remain = Arrays.copyOfRange(remain, n, remain.length); // this is OK, because we have total control over remain.
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
                // buf = Arrays.copyOf(remain, remain.length); // this will be a problem,
                // because, we will reset the length of buf !!!!
                // however, without this, we can assume that buf has a length greater than or equal to n!!!!
                n = n - remain.length;
                totalCount += remain.length;
                // do this after the total count has changed.
                // thus, update remain to consists of nothing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
