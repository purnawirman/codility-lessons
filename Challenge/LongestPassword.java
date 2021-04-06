// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        int result = 0;
        for (String password: S.split(" ")) {
            if (isValid(password)) {
                result = Math.max(result, password.length());
            }
        }
        return result;
    }

    boolean isValid(String password) {
        int digit = 0;
        int letter = 0;
        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            int fromLowerA = (int) c - 'a';
            int fromUpperA = (int) c - 'A';
            int fromZero = (int) c - '0';
            if ((fromLowerA >= 0 && fromLowerA < 26) || 
                (fromUpperA >= 0 && fromUpperA < 26)) {
                letter++;
            } else if (fromZero >= 0 && fromZero < 10) {
                digit++;
            } else {
                return false;
            }
        }
        return letter % 2 == 0 && digit % 2 == 1;
    }
}
