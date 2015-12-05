/**
 * @see <a href="https://leetcode.com/problems/paint-fence/">Paint Fence</a>
 */

public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k * k;
        int[] num = new int[n];
        num[0] = k;
        num[1] = k * k;
        for (int i = 2; i < n; i ++) {
            num[i] = (k - 1)*(num[i - 1] + num[i - 2]);
        }
        return num[n - 1];
        
        /*
        if (n <= k) {
            int res = 1;
            for (int i = k; i >= k - n + 1; i --) {
                res *= i;
            }
            return res;
        }
        */
        /*
        // n > k && n <= 2*k
        int minColor = (n%2 == 0 ? n/2 : (n+1)/2);
        int nWays = 0;
        for (int j = minColor; j <= Math.min(k, n); j ++) {
            // from k colors, only choose j colors
            int combination = 1;
            int max = Math.max(j, k - j);
            for (int i = k; i >= k - max + 1; i --) {
                combination *= i;
            }
            for (int i = 1; i <= max; i ++) {
                combination /= i;
            }
            
            nWays += combination*calculate(j, n); // j is the number of colors to be used; n is the number of posts.
        }
        return nWays;
        */
        
        // using factorial, will have integer overflow!!!!!!!!!!!! Causing weired problems/errors.
        // need to calculate one by one ????????????????????????????
        /*
        int factorial[] = new int[Math.max(n, k) + 1];
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i ++) {
            factorial[i] = factorial[i-1]*i;
        }
        if ( n <= k) {
            return factorial[k] / factorial[k - n];
        }
        else // k < n and n <= 2*k
        {
            int duplicate = n - k;
            int combine = factorial[k] / (factorial[n-k] * factorial[2*k - n]);
            return combine* factorial[k];
        }
        */
        
        
        // method 1: recursive solution: will incur some repeated calculations
        //           may have time limit exceeded.
        // method 2: dynamic programming.
        // numsOfWays[i][j]: the number of ways to paint i posts with j colors.
        
        // in the following solution: 
        // the whole logic is wrong !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
        /*
        int numOfWays[][] = new int[n+1][k+1];
        numOfWays[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            numOfWays[i][0] = 0; // no colors, but there are posts, num of ways equals 0.
            if (k >= 1)
                numOfWays[i][1] = 1; // 1 colars, no matterh how many posts, num of ways equals 1.
        }
        for (int i = 1; i < k + 1; i ++) {
            numOfWays[0][i] = 1;
            if (n >= 1)
                numOfWays[1][i] = i;
        }
        for (int i = 2; i <= n; i ++) {
            for (int j = 2; j <= k; j ++) {
                numOfWays[i][j] = j * numOfWays[i - 2][j - 1] 
                                 + j * (j - 1) * numOfWays[i - 2][j - 1];
            }
        }
        return numOfWays[n][k];
        */
    }
    
    /* will overflow, whether you calculate using an array or using a function
    public int factorial(int n) {
        int res = 1;
        for (int i = 2; i < n; i ++) {
            res *= i;
        }
        return res;
    }
    */
    /*
    public int calculate(int k, int n) {
        // if using k colors, some colors must be duplicated.
        int dup = n - k;
        int combination = 1;
        dup = Math.max(dup, k - dup);
        for (int i = k; i >= k - dup + 1; i --) {
            combination *= i;
        }
        for (int i = 1; i <= dup; i ++) {
            combination /= i;
        }
        int res = combination;
        for (int i = 1; i <= k; i++) {
            res *= k;
        }
        return res;
    }
    */
    

}
