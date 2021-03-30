// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int[] times = new int[X];
        Arrays.fill(times, -1);
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X)
                times[A[i] - 1] = times[A[i] - 1] == -1? i: Math.min(times[A[i] - 1], i);
        }
        // print(times);
        int result = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] < 0) return -1;
            result = Math.max(result, times[i]);
        }
        return result;

    }
    void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.println();
    }
}
