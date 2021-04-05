// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = A[i];
            int term = Integer.MIN_VALUE;
            for (int j = 1; j <= 6 && i - j >= 0; j++) {
                term = Math.max(term, dp[i-j]);
            }
            dp[i] = dp[i] + term;
        }
        return dp[A.length - 1];
    }
}
