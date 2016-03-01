/**
 * @see <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 */

public class Solution {
    public String getHint(String secret, String guess) {        
        int correct = 0;
        Map<Character, Integer> hm1 = new HashMap<>(), hm2 = new HashMap<>();
        
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++correct;
            } else {
                char c = secret.charAt(i);
                hm1.put(c, hm1.containsKey(c) ? hm1.get(c) + 1 : 1);
                c = guess.charAt(i);
                hm2.put(c, hm2.containsKey(c) ? hm2.get(c) + 1 : 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(correct);
        sb.append('A');
        int cows = 0;
        for (char c : hm2.keySet()) {
            if (hm1.containsKey(c)) {
                cows += Math.min(hm1.get(c), hm2.get(c));
            }
        }
        sb.append(cows);
        sb.append('B');
        return new String(sb);
    }
}
