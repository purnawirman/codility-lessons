// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];
        int max = 0;
        int baseline = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) {
                baseline = max;
            } else {
                result[A[i] - 1] = Math.max(baseline, result[A[i] - 1]) + 1;
                max = Math.max(max, result[A[i] - 1]);
            }
        }
        for (int i = 0; i < result.length; i++) 
            result[i] = Math.max(result[i], baseline);
        return result;
    }
}
