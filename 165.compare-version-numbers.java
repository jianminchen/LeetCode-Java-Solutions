/**
 * @see <a href="https://leetcode.com/problems/compare-version-numbers/">Compare Version Numbers</a>
 */

public class Solution {
    public int compareVersion(String version1, String version2) {
        int i1 = 0;
        int i2 = 0;
        while (i1 < version1.length() || i2 < version2.length()) {
            int start1 = i1;
            while (i1 < version1.length() && version1.charAt(i1) != '.') i1 ++;
            int end1 = i1;
            
            int start2 = i2;
            while (i2 < version2.length() && version2.charAt(i2) != '.') i2 ++;
            int end2 = i2;

            int num1 = 0; 
            int num2 = 0; // if one version reachs its end, we use 0 as its future digits.
            if (start1 != end1) num1 = Integer.parseInt(version1.substring(start1, end1));
            if (start2 != end2) num2 = Integer.parseInt(version2.substring(start2, end2));
            if (num1 < num2) return -1;
            else if (num1 > num2) return 1; 
            else {
                i1 ++;
                i2 ++;
            }
        }
        
        return 0;
    }
}
