// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        for (int i = 0; i < A.length; i++) {
            while ( A[i] >= 1 && A[i] <= A.length 
                && A[i] != i + 1
                && A[i] != A[A[i] - 1]) {
                    swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
