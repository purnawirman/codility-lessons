// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, int M) {
        // write your code in Java SE 8
        return Math.max(N, M) / gcd(N, M, 1);
    }

    int gcd(int a, int b, int res) {
        if (a == b) return res * a;
        else if ((a & 1)== 0 && (b & 1)== 0) return gcd(a >> 1, b >> 1, 2 * res);
        else if ((a & 1)== 0) return gcd(a >> 1, b, res);
        else if ((b & 1)== 0) return gcd(a, b >> 1, res);
        else if (a > b) return gcd(a - b, b, res);
        return gcd(a, b - a, res);
    }
}
