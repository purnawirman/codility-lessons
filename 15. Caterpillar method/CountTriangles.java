// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 3) return 0;
        Arrays.sort(A);
        int result = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int k = i + 2;
            for (int j = i+1; j < A.length - 1; j++) {
                k = Math.max(k, j+1);
                while (k < A.length && A[i] + A[j] > A[k]) {
                    k++;
                }
                result += k - j - 1;
            }
        }
        return result;
    }
}
