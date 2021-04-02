// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] result = new int[P.length];
        int[] sieve  = createSieve(Math.max(max(P), max(Q)));
        int[] prefix = createPrefix(sieve, P, Q);
        for (int i = 0; i < P.length; i++) {
            result[i] = prefix[Q[i]] - prefix[P[i] - 1];
        }
        return result;
    }

    private int[] createPrefix(int[] sieve, int[] P, int[] Q) {
        int[] prefix = new int[sieve.length];
        for (int i = 1; i < sieve.length; i++) {
            prefix[i] = prefix[i-1] + (isSemi(sieve, i)? 1: 0);
        }
        return prefix;
    }

    private boolean isSemi(int[] sieve, int val) {
        return sieve[val] != 0 && sieve[val / sieve[val]] == 0;
    }

    private int[] createSieve(int N) {
        int[] sieve = new int[N + 1];
        if (N < 2) return sieve;
        for (int i = 2; i * i <= N; i++) {
            if (sieve[i] == 0) {
                int k = i * i;
                while (k <= N) {
                    if (sieve[k] == 0) {
                        sieve[k] = i;
                    }
                    k += i;
                }
            }
        }
        return sieve;
    }

    private int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
