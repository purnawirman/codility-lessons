// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        if (A.length <= 1) return 1;
        int result = 0;
        // write your code in Java SE 8
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            intervals.add(new Interval(i - A[i], i + A[i]));
        }
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>(A.length, 
            (i1, i2) -> Integer.compare(i1.end, i2.end));
        
        for(Interval itv: intervals) {
            while (pq.size() > 0 && itv.start > pq.peek().end) {
                pq.poll();
            }
            result += pq.size();
            pq.add(itv);
        }

        return result;
    }

    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        } 
    }
}
