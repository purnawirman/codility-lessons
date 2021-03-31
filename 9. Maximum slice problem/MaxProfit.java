// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length <= 1) return 0;
        int best = 0;
        int minPrice = A[0];
        for (int i = 0; i < A.length; i++) {
            minPrice = Math.min(minPrice, A[i]);
            best = Math.max(best, A[i] - minPrice);
        }

        return best;
    }
}
