// you can also use imports, for example:
import java.util.*;

// binary search will not work
// see this input 0 1 0 1   0 0 0 0    1 0 1 0
// 1 - possible, 2 - possible, 3 - not, 4 - possible

class Solution {
    public int solution(int[] A) {
        
        // main idea:
        // 1) find all the peaks, and put them into a List
        // 2) try to divide the array into a number of groups,
        //    and check if all the groups have at least one peak
        //--> if yes, return the "number of groups"
        
        // use "List" to store all the peaks
        List<Integer> peaksIndexList = new ArrayList<>();
        
        // 1) find the peaks (and store them)
        for(int i=1; i<A.length-1; i++){
            if( A[i-1]<A[i] && A[i]>A[i+1] ){ // A[i] > A[i-1], A[i] > A[i+1]
                peaksIndexList.add(i);
            }
        }
        
        // 2) check the number of Blocks
        int N = A.length;
        
        // from the "biggest possible number" to smaller number
        for(int numBlocks = N; numBlocks >= 1; numBlocks--){
                    
            if( N % numBlocks ==0){ // it is divisible   
            
                int blockSize = N / numBlocks; 
                int lower = 0;
                int found = 0;
                int ithOkBlock =0;  // the ith block has peak(s)

                // test all the peaks 
                // if a peak is found in the ith block
                // then, go to the (i+1)th block
                for(int peaksIndex : peaksIndexList){
                    int upper = lower + blockSize - 1;
                    if (peaksIndex >= lower && peaksIndex <= upper) {
                        found++;
                        lower = lower + blockSize;
                    }
                    if (found >= numBlocks) return numBlocks;
                }   
            }
        }   
        
        return 0;
    }
}
