/**
 * @see <a href="https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/">Read N Characters Given Read4 II - Call multiple times</a>
 */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private char[] buffer = new char[4];
    // offset is the index from where we should copy contents in buffer
    // bufsize is the number of bytes that have not been read in the buffer
    private int offset = 0, bufsize = 0;
    /**
    * @param buf Destination buffer
    * @param n   Maximum number of characters to read
    * @return The number of characters read
    */
    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false; // whether we have reached the end
        while (!eof && readBytes < n) {
            if (bufsize == 0) { // if all content in the buffer has been read, we need to read again
                bufsize = read4(buffer);
                eof = bufsize < 4; // whether we have reached the end
            }
            int bytes = Math.min(n - readBytes, bufsize);
            // it's good to know some handy "system calls"
            System.arraycopy(buffer, offset, buf, readBytes, bytes);
            offset = (offset + bytes) % 4;
            bufsize -= bytes;
            readBytes += bytes;
        }
        return readBytes;
    }
}
