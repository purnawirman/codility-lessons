// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[][] prefix = new int[3][S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                prefix[0][i] = (i > 0? prefix[0][i-1]: 0) + 1;
            } else if (S.charAt(i) == 'C') {
                prefix[1][i] = (i > 0? prefix[1][i-1]: 0) + 1;
            } else if (S.charAt(i) == 'G') {
                prefix[2][i] = (i > 0? prefix[2][i-1]: 0) + 1;
            }
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            if (getSum(prefix[0], P[i], Q[i]) > 0) {
                result[i] = 1;
            } else if (getSum(prefix[1], P[i], Q[i]) > 0) {
                result[i] = 2;
            } else if (getSum(prefix[2], P[i], Q[i]) > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;

    }

    private int getSum(int[] pre, int i, int j) {
        return pre[j] - (i > 0? pre[i-1]: 0);
    }
}
