/**
 * @see <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 */

public class Solution {
    public String getHint(String secret, String guess) {
        // using set is still wrong!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // Set<Character> set1 = new HashSet<Character>();
        // Set<Character> set2 = new HashSet<Character>();
        
        int correct = 0;
        Map<Character, Integer> hm1 = new HashMap<>();
        Map<Character, Integer> hm2 = new HashMap<>();
        
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                correct ++;
            }
            else {
                if (hm1.containsKey(secret.charAt(i))) {
                    hm1.put(secret.charAt(i), hm1.get(secret.charAt(i)) + 1);
                }
                else hm1.put(secret.charAt(i), 1);
                if (hm2.containsKey(guess.charAt(i))) {
                    hm2.put(guess.charAt(i), hm2.get(guess.charAt(i)) + 1);
                }
                else hm2.put(guess.charAt(i), 1);
                
                //set1.add(secret.charAt(i));
                //set2.add(guess.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(correct);
        sb.append('A');

        /*
        // cannot do the simple subtraction !!!!!!!!!!!!!!!!!??????????????????
        sb.append(secret.length() - correct);
        sb.append('B');
        */
        int cows = 0;
        Set<Character> guessSet = hm2.keySet();
        for (Character c : guessSet) {
            if (hm1.containsKey(c)) {
                cows += Math.min(hm1.get(c), hm2.get(c));
            }
        }
        
        sb.append(cows);
        sb.append('B');
        
        return new String(sb);
        
        // both the bulls and cows indicate that the digit is in the secret number.
        // cases:
        // 1122 vs. 2211 return 0A4B
        // 3331 vs. 1131 return ?
        // 1113 vs. 1331 return ?
        // 3145 vs. 1333 return ?
    }
}
