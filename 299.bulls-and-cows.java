/**
 * @see <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 */

public class Solution {
    public String getHint(String secret, String guess) {        
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
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(correct);
        sb.append('A');
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
    }
}
