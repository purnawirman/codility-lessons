// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(Tree T) {
        // write your code in Java SE 8
        return height(T);
    }

    int height(Tree T) {
        if (T == null) return -1;
        return 1 + Math.max(height(T.l), height(T.r));
    }
}
