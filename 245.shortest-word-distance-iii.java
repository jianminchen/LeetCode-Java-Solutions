/**
 * @see <a href="https://leetcode.com/problems/shortest-word-distance-iii/">Shortest Word Distance III</a>
 */

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        String fdWord = null;
        int fdIndex = -1;
        int minDist = words.length;
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                String newFound = words[i];
                if (fdWord == null) {
                    fdWord = words[i];
                    fdIndex = i;
                }
                else {
                    if (newFound.equals(fdWord)) {
                        if (word1.equals(word2)) {
                            // update the minDist if possible.
                            minDist = Math.min(minDist, i - fdIndex); 
                            fdIndex = i; // update the index;
                        }
                        else { // not equal
                            fdIndex = i; // only update the index.
                        }
                    }
                    // newFound not equal to fdWord.
                    else { // word1 and word2 must not be equal, otherwise, newFound and fdWord will be equal
                        minDist = Math.min(minDist, i - fdIndex);
                        fdWord = newFound; // update the found word
                        fdIndex = i; // update the index for the found word.
                    }
                }
                if (1 == minDist) break;
            }
        }
        return minDist;
    }
}
