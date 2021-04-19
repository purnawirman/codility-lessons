// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    // test suite
    // (2, [], [])

    // (2, [1, 1], [])

    // (2, [], [1,1])

    // (2, [1,1], [1,1])

    // (2, [1, 2, 1, 1], [1, 4, 3, 2, 4])

    // (0, [1, 2, 1, 1], [1, 4, 3, 2, 4])

    // (3, [1, 2, 1, 1], [1, 4, 3, 2, 4])

    // (4, [1, 2, 1, 1], [1, 4, 3, 2, 4])


    public int solution(int K, int[] C, int[] D) {
        // write your code in Java SE 8
        int result = 0;
        int[] countC = getCount(C);
        int[] countD = getCount(D);

        // get pair from clean array
        for (int i = 1; i < countC.length; i++) {
            if (countC[i] >= 1) {
                result += countC[i] / 2;
                countC[i] %= 2;
            }
        }

        // get pair from clean and dirty
        for (int i = 1; i < countC.length && K > 0; i++) {
            if (countC[i] == 1 && countD[i] >= 1) {
                K--;
                result++;
                countD[i]--;
            }   
        }

        // get pair from dirty
        for (int d = 1; d < countD.length; d++) {
            while (countD[d] >= 2 && K >= 2) {
                countD[d] -= 2;
                K -= 2;
                result++;
            }
        }
        

        return result;
    }

    int[] getCount(int[] A) {
        int[] result = new int[51];
        for (int i = 0; i < A.length; i++)
            result[A[i]]++;
        return result;
    }

}
