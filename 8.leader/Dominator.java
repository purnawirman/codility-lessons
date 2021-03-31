// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int candidate = -1;
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (size == 0) {
                candidate = A[i];
                size = 1;
            } else {
                if (A[i] == candidate) {
                    size++;
                } else {
                    size--;
                }
            }
        }

        size = 0;
        int result = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                size++;
                result = i;
            }
        }

        return size > A.length / 2? result: -1;
    }
}
