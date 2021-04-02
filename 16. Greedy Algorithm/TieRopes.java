// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int K, int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int length = 0;
        for (int i = 0; i < A.length; i++) {
            if (length + A[i] >= K) {
                length = 0;
                result++;
            } else {
                length += A[i];
            }
        }

        return result;
    }
}
