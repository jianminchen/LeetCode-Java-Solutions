public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] count = new int[amount];
        // should initialize as -1. !!!!!!!!!!!!!
        Arrays.fill(count, -1);
        
        for (int am = 1; am <= amount; ++am) {
            // count[am - 1] will be the minimum count for am.
            int minCount = Integer.MAX_VALUE;
            for (int i : coins) {
                if (am == i) {
                    minCount = 1;
                    break;
                }
                else if (am < i) {
                    ; // skip
                }
                else {
                    // am > i;
                    
                    // both places !!! here, we also use count[am - i - 1] instead of count[am - i];
                    if (/*count[am - i] != -1*/ count[am - i - 1] != -1) {
                        // should use am - i - 1, instead of am - i.!!!!!!!!!!!!!
                        minCount = Math.min(1 + count[am - i - 1], minCount);
                    }
                }
            }
            
            if (minCount == Integer.MAX_VALUE) count[am - 1] = -1;
            else count[am - 1] = minCount;
        }
        // for (int i = 0; i < amount; ++i) System.out.println(count[i]);
        return count[amount - 1];
    }
}
