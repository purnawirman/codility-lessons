// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    
    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> fib = getFib();
        int[] dp = new int[A.length + 1];
        for (int i = 0; i <= A.length; i++) {
            if (i == A.length || A[i] == 1) {
                int minStep = Integer.MAX_VALUE;
                for (Integer fj: fib) {
                    int prevIdx = i - fj;
                    if (prevIdx < -1) break;
                    if (prevIdx == -1){
                        minStep = 1; // directly from source
                    } else if (A[prevIdx] == 1 && dp[prevIdx] > 0) {
                        minStep = Math.min(minStep, 1 + dp[prevIdx]);
                    }
                }
                if(minStep == Integer.MAX_VALUE) {
                    dp[i] = -1;
                } else {
                    dp[i] = minStep;
                }
            }
        }
        return dp[A.length];
    }

    void print(int[] A) {
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] +", ");
        System.out.println();
    }

    private List<Integer> getFib() {
        int LIMIT = 100000;
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        while(fib.get(fib.size() - 1) <= LIMIT) {
            int n = fib.size();
            fib.add(fib.get(n-1) + fib.get(n-2));
        }
        fib.remove(fib.size() - 1);
        return fib;
    }
}
