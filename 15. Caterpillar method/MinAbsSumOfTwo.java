// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int left = 0, right = A.length - 1;
        int best = Integer.MAX_VALUE;
        while (left <= right) {
            int sum = A[left] + A[right];
            if (sum == 0) return 0;
            else if (sum > 0) {
                right--;
                best = Math.min(best, sum);
            } else {
                left++;
                best = Math.min(best, -sum);
            }
        }
        return best;
    }
}
