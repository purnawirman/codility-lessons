// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (hasSameDivisor(A[i], B[i])) result++;
        }
        return result;
    }

    boolean hasSameDivisor(int a, int b) {
        int G = gcd(a, b, 1);
        // a and G has to share same divisors
        // also b and G has to share same divisors
        // means a/G divisors are subset of G divisors
        // b/G divisors are subset of G divisors
        int gcdA = G;
        a /= G;
        while (gcdA > 1) {
            gcdA = gcd(a, G, 1);
            a /= gcdA;
        }
        if (a > 1) return false;

        int gcdB = G;
        b /= G;
        while (gcdB > 1) {
            gcdB = gcd(b, G, 1);
            b /= gcdB;
        }
        if (b > 1) return false;

        return true;
    }

    int gcd(int a, int b, int res) {
        if (a == b) return res * a;
        else if ((a&1) == 0 && (b&1) == 0) return gcd(a/2, b/2, 2 * res);
        else if ((a&1) == 0) return gcd(a/2, b, res);
        else if ((b&1) == 0) return gcd(a, b/2, res);
        else if (a > b) return gcd(a-b, b, res);
        return gcd(a, b-a, res);
    }
}
