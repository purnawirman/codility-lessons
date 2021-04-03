// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 1) return 1;
        
        int lo = 0, hi = A.length - 1;
        int result = 0;
        while (lo <= hi) {
            while (lo <= A.length - 2 && A[lo] == A[lo + 1]) {
                lo++;
            }
            while (hi >= 1 && A[hi] == A[hi - 1]) {
                hi--;
            }

            if (A[lo] + A[hi] == 0) {
                lo++;
                hi--;
            } else if (Math.abs((long) A[lo]) < Math.abs((long) A[hi])) {
                hi--;
            } else {
                lo++;
            }
            result++;

        }
        return result;
    }
}
