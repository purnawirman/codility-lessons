// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = Integer.MIN_VALUE;
        int cur = 0;

        for (int i = 0; i < A.length; i++) {
            cur = Math.max(0, cur) + A[i];
            result = Math.max(result, cur);
        }
        return result;
    }
}
