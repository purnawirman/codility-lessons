// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A) {
        // write your code in Java SE 8
        // count map
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            countMap.put(A[i], 1 + countMap.getOrDefault(A[i],0));
        } 

        // count number of divisors for each unique element in array
        Map<Integer, Integer> nonDivisorMap = new HashMap<>();
        for (Integer val: countMap.keySet()) {
            int sqrt = (int) Math.sqrt(val);
            int noDivisors = 0;
            for (int i = 1; i <= sqrt; i++) {
                if (val % i == 0) {
                    noDivisors += countMap.getOrDefault(i, 0);
                    if (i * i != val) noDivisors += countMap.getOrDefault(val / i, 0);
                }
            }
            nonDivisorMap.put(val, A.length - noDivisors);
        }

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = nonDivisorMap.get(A[i]);
        }
        return result;
    }
}
