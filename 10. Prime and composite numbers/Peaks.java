// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        if (A.length < 3) return 0;
        // write your code in Java SE 8

        // find factors of N A.length, smaller than number of peaks n
        // binary search through the first failing block division
        // if nothing is failing, use max

        // find all peaks
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks.add(i);
            }
        }
        if (peaks.size() <= 1) return peaks.size();
        // construct factors of N
        int n = peaks.size();
        List<Integer> searchArr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sqrt = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrt && i <= n; i++) {
            if (i * i == N) {
                searchArr.add(i);
            } else if (N % i == 0) {
                searchArr.add(i);
                if (N / i <= n){
                    temp.add(N / i);
                }
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            searchArr.add(temp.get(i));
        }
        // binary search
        // for (int mid = 3; mid <= 3; mid++)
        //     System.out.println("mid: "+ mid + ", checkfail: " + checkFail(peaks, mid, N));
        // return 1;
        int lo = 0;
        int hi = searchArr.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
        
            if (checkFail(peaks, searchArr.get(mid), N)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (!checkFail(peaks, searchArr.get(lo), N)) return searchArr.get(searchArr.size() - 1);
        return searchArr.get(lo - 1);
    }

    void print(List<Integer> peaks) {
        for (Integer p: peaks) System.out.print(p + ", ");
        System.out.println();
    }

    private boolean checkFail(List<Integer> peaks, int block, int N) {
        if (peaks.size() == 0) return true;
        int found = 0;
        int lower = 0;
        for (int pidx = 0; pidx < peaks.size(); pidx++) {
            int upper = lower + N / block - 1;
            // System.out.println("low: " + lower + ", upp: " + upper + ", peak: " + peaks.get(pidx));
            if (peaks.get(pidx) >= lower && peaks.get(pidx) <= upper) {
                found++;
                lower = lower + N / block;
            }
            if (found >= block) return false;
        }
        return true;
    }
}
