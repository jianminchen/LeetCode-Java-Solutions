/**
 * @see <a href="https://leetcode.com/problems/count-primes/">Count Primes</a>
 */

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        // previously, written as boolean[0] = false, boolean[1] = true. 
        // what the hell??????????????????!!!!!!!!!!!!!!!!!!!
        // boolean is the type name, isPrime is the variable name.

        isPrime[0] = false;
        isPrime[1] = true;
        for (int i = 2; i < n; i ++) {
            isPrime[i] = true;
        }
        // boolean[i] mean whether i + 1 is a prime.
        int count = 0;
        // j is the number to be considered, thus, don’t consider n!!!!!!!!!!!!!!!!
        // thus, we can only go to j = n - 1.
        for (int j = 2; j <= n - 1; j ++) { 
            if (isPrime[j-1] == true) {
                count ++;
                int i = 2;
                while (i * j < n) {
                    isPrime[i * j - 1] = false;
                    i ++;
                }
            }
        }
        return count;
    }
}
