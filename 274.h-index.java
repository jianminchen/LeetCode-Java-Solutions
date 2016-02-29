/**
 * @see <a href="https://leetcode.com/problems/h-index/">H-Index</a>
 */

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if (citations.length == 0) return 0;

        int low = 0, high = citations.length - 1;
        while (true) {
            if (low == high) {
                return Math.min(citations[low], citations.length - low);
            }
            int mid = low + ((high - low)>>1);
            if (citations[mid] > citations.length - mid) {
                high = mid;
            } else if (citations[mid] == citations.length - mid) {
                return citations.length - mid; 
            } else { // citations[mid] < citations.length - mid.
                low = mid + 1;
            }
        }
    }
}
