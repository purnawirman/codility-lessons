// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        if (A.length < 3) return 0;
        // write your code in Java SE 8
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks.add(i);
            }
        }


        int lo = 0;
        int hi = peaks.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (checkFail(peaks, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (!checkFail(peaks, lo)) return peaks.size();
        return lo - 1;
    }

    void print(List<Integer> peaks) {
        for (Integer p: peaks) System.out.print(p + ", ");
        System.out.println();
    }

    boolean checkFail(List<Integer> peaks, int flag) {
        if (flag == 0) return false;
        if (peaks.size() < flag) return true;

        int prevPeak = peaks.get(0);
        int used = 1;
        for (int i = 0; i < peaks.size(); i++) {
            if (peaks.get(i) - prevPeak >= flag) {
                prevPeak = peaks.get(i);
                used++;
            }
            if (used >= flag) {
                return false;
            }
        }
        return true;
    }
}
