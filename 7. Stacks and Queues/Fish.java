// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        Deque<Fish> stack = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            Fish cur = new Fish(A[i], B[i], true);
            while(!stack.isEmpty() && stack.peekFirst().dir == 1 && cur.dir == 0) {
                Fish top = stack.peekFirst();
                if (top.size > cur.size) {
                    cur.alive = false;
                    break;
                } else {
                    stack.removeFirst();
                }
            } 
            if (cur.alive) stack.addFirst(cur);
        }
        return stack.size();
    }

    class Fish {
        int size;
        int dir;
        boolean alive;

        Fish(int size, int dir, boolean alive) {
            this.size = size;
            this.dir = dir;
            this.alive = alive;
        }
    }
}
