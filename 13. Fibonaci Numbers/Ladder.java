// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int[] result = new int[A.length];
        int[] dp = getDP(getMax(A), getMax(B));

        for (int i = 0; i < A.length; i++) {
            result[i] = dp[A[i]] % (1 << B[i]);
        }
        return result;
    }

    private int[] getDP(int N, int power) {
        int limit = (1 << power);
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= limit;
        }
        return dp;
    }

    private int getMax(int[] B) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < B.length; i++) {
            result = Math.max(result, B[i]);
        }
        return result;
    }
}
