// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8
        if (max(B) < min(C) || max(C) < min(A)) return -1;

        List<Plank> planks = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            planks.add(new Plank(A[i], B[i]));
        }
        Collections.sort(planks, new PlankComparator());

        for (int i = 0; i < C.length; i++) {
            int pIdx = find_plank(planks, C[i]);
            while (pIdx > -1) {
                planks.remove(pIdx);
                pIdx = find_plank(planks, C[i]);
            }
            if (planks.size() == 0) return i + 1;
        }
        return -1;
    }

    class Plank {
        int start;
        int end;
        Plank (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public class PlankComparator implements Comparator<Plank> {
        @Override
        public int compare(Plank first, Plank second) {
            if (first.start != second.start) {
                return Integer.compare(first.start, second.start);
            } else {
                return Integer.compare(first.end, second.end);
            }
        }
    }

    int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    int find_plank(List<Plank> planks, int nail) {
        if (planks.size() == 0) return -1;
        int lo = 0, hi = planks.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (planks.get(mid).start > nail) {
                hi = mid - 1;
            } else if (planks.get(mid).end < nail) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

