// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        if (A.length <= 1) return A.length;
        int result = 1;
        int prevEnd = B[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > prevEnd) {
                result++;
                prevEnd = B[i];
            }
        }
        return result;
    }
}
