// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(S.charAt(i));
            } else {
                if (stack.isEmpty()) return 0;
                Character top = stack.removeFirst();
                if (!((top == '(' && c == ')') 
                       || (top == '{' && c == '}') 
                       || (top == '[' && c == ']'))) {
                           return 0;
                       }
            }
        }
        return 1;
    }
}
