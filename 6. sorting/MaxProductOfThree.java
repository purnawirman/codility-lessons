// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 3) return 0;
        int n = A.length;
        Arrays.sort(A);
        int toptoptop = A[n-1] * A[n-2] * A[n-3];
        int topbotbot = A[n-1] * A[0] * A[1];

        return Math.max(toptoptop, topbotbot);
    }
}
