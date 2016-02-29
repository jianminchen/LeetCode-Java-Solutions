/**
 * @see <a href="https://leetcode.com/problems/count-primes/">Count Primes</a>
 */

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];

        isPrime[0] = false;
        isPrime[1] = true;
        for (int i = 2; i < n; ++i) {
            isPrime[i] = true;
        }
        int count = 0;
        for (int j = 2; j <= n - 1; ++j) { 
            if (isPrime[j-1]) {
                ++count;
                int i = 2;
                while (i * j < n) {
                    isPrime[i * j - 1] = false;
                    ++i;
                }
            }
        }
        return count;
    }
}
