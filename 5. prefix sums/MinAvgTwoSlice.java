// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // basic idea is if the length of subarray allowed to be 1,
        // then we would have allowed finding min(A) as the answer
        // but since we have to pick at least 2 elements as the subarray
        // we use the same logic to find minimum of 
        // min(A subarray of length 2)
        // min(A subarray of length 3) 
        // it is a greedy solution, but also intuitively makes sense since any 
        // subarray of length n > 3, it will compose of elements from min(A ubarray of length 2) and min(A subarray of length 3)
        
        if (A.length < 2) return 0;

        double[] prefix = new double[A.length];
        for (int i = 0; i < A.length; i++)
            prefix[i] = (i > 0? prefix[i-1]: 0) + A[i];

        int bestIdx = -1;
        double minAve = (double) Integer.MAX_VALUE;
        for (int i = 0; i + 1 < A.length; i++) {
            double duoAve = getAve(prefix, i, i + 1);
            double tripleAve = (double) Integer.MAX_VALUE;
            if (i + 2 < A.length) 
                tripleAve = getAve(prefix, i, i + 2);
            if (duoAve < minAve || tripleAve < minAve) {
                minAve = Math.min(duoAve, tripleAve);
                bestIdx = i;
            }
        }
        return bestIdx;
        

    }

    void print(int[] A) {
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + ", ");
        System.out.println();
    }
    
    private double getAve(double[] prefix, int P, int Q) {
        return (prefix[Q] - (P > 0? prefix[P-1]: 0)) / (Q - P + 1);
    }
}
