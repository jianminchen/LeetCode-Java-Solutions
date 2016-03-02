/**
 * @see <a href="https://leetcode.com/problems/read-n-characters-given-read4/">Read N Characters Given Read4</a>
 */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
// TODO: do not use al, copying directly to buf from subbuf using System.copy
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        ArrayList<Character> al = new ArrayList<Character>();
        // the list will have the length, we do not need to record the count explicitly
        // int count = 0;
        
        while (n > 0) {
            char[] subbuf = new char[4];
            int subcount = read4(subbuf);
            for (int i = 0; i < Math.min(subcount, n); ++i) {
                al.add(subbuf[i]);
            }
            n -= Math.min(subcount, n);
            if (subcount < 4) break; // already reached end of file.
        }
        for (int i = 0; i < al.size(); ++i) {
            buf[i] = al.get(i);
        }
        return al.size();
    }
}
