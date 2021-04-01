// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        int lo = 0;
        int hi = M * A.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(A, K, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean check(int[] A, int K, int maximal) {
        int cumsum = 0;
        int block = 1;
        for (int i = 0; i < A.length; i++) {
            if (cumsum + A[i] <= maximal) {
                cumsum += A[i];
            } else {
                block++;
                cumsum = A[i];
            }
            if (block > K) return false;
        }
        return true;
    }
}
