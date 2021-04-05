// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int M, int[] A) {
        // write your code in Java SE 8
        final int LIMIT = 1000000000;
        int result = 0;
        int[] counters = new int[M];
        int head = 0; 
        for (int tail = 0; tail < A.length; tail++) {
            while (counters[A[tail]] > 0) { // seen it before
                counters[A[head]] = counters[A[head]] - 1;
                head++;
            }
            result += tail - head + 1;
            if (result > LIMIT) return LIMIT;
            counters[A[tail]] = counters[A[tail]] + 1;
        }
        return result;
    }
}
