/**
 * https://leetcode.com/problems/super-ugly-number/
 */

public class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    if (primes == null) {
      throw new NullPointerException();
    }
    if (n < 1 || primes.length == 0) {
      throw new IllegalArgumentException();
    }
    int[] list = new int[n]; // to store n super ugly numbers
    list[0] = 1;
    int primeCount = primes.length;
    int[] index = new int[primeCount];
    int[] candidates = new int[primeCount];

    for (int i = 1; i <= n - 1; ++i) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < primeCount; ++j) {
        candidates[j] = list[index[j]] * primes[j];
        if (min > candidates[j]) {
          min = candidates[j];
        }
      }
      for (int j = 0; j < primeCount; ++j) {
        if (min == candidates[j]) {
          ++index[j];
        }
      }
      list[i] = min;
    }
    return list[n - 1];
  }
}
