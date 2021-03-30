// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // it is not a permutation if either of the following conditions:
        // - out of bound 1 <= x <= n
        // - have duplicates
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 1 || A[i] > A.length || set.contains(A[i])) {
                return 0;
            }
            set.add(A[i]);
        }

        return 1;
    }
}
