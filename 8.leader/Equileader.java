// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 11
        // write your code in Java SE 8
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);

        int size = 0;
        int candidate = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (size == 0) {
                candidate = A[i];
                size++;
            } else {
                if (A[i] == candidate) {
                    size++;
                } else {
                    size--;
                }
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(candidate) > (i + 1) / 2) {
                left[i] = candidate;
            }
        }

        size = 0;
        candidate = 0;
        map = new HashMap<Integer, Integer>();
        for (int i = A.length - 1; i >= 1; i--) {
            if (size == 0) {
                candidate = A[i];
                size++;
            } else {
                if (A[i] == candidate) {
                    size++;
                } else {
                    size--;
                }
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(candidate) > (A.length - i) / 2) {
                right[i] = candidate;
            }
        }

        int result = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (left[i] != Integer.MAX_VALUE 
                && right[i+1] != Integer.MAX_VALUE &&
                left[i] == right[i+1]){
                    result++;
                }
        }
        return result;
    }

    void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.println();
    }
}
