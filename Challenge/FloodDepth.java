// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 3) return 0;
        int maxDepth = 0;

        // find the first descending element sequence
        int start = 0;
        while (start + 1 < A.length && A[start] <= A[start+1]) {
            start++;
        }
        if (start == A.length) return 0;

        // start using stack
        Deque<Node> stack = new ArrayDeque<>();
        for(;start < A.length; start++) {
            if (stack.isEmpty() || A[start] < stack.peekFirst().height) {
                stack.addFirst(new Node(A[start], A[start]));
            } else {
                int bottom = Integer.MAX_VALUE;
                int pillar = A[start];
                Node last = stack.peekFirst();
                while (!stack.isEmpty() && stack.peekFirst().height < A[start]) {
                    last = stack.removeFirst();
                    bottom = Math.min(bottom, last.bottom);
                }
                pillar = Math.min(pillar, 
                            stack.isEmpty()? last.height: stack.peekFirst().height);
                maxDepth = Math.max(pillar - bottom, maxDepth);
                stack.addFirst(new Node(A[start], bottom));
            }
            // print(stack);
            // System.out.println("depth: " + maxDepth);
        }

        return maxDepth;
    }

    class Node {
        int bottom;
        int height;
        Node (int height, int bottom) {
            this.bottom = bottom;
            this.height = height;
        }
    }

    void print(Deque<Node> stack) {
        Iterator iter = stack.iterator();
        System.out.print("Stack: {");
        while(iter.hasNext()) {
            Node cur = (Node) iter.next();
            System.out.print(cur.height + ", ");
        }
        System.out.println();
    }
}
