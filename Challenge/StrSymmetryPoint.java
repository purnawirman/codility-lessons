// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        if (S.length() % 2 == 0) return -1;
        return isPalindrome(S)? S.length() / 2: -1;
    }
    boolean isPalindrome(String S) {
        int left = 0, right = S.length() - 1;
        while (left < right) {
            if (S.charAt(left++) != S.charAt(right--)) return false;
        }
        return true;
    }
}
