import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count =0;
        if(intervals.length == 0 || intervals == null) {
            return count;
        }
        
        //for ()
        //Arrays.sort(intervals);
        //Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int lastValidIntervalIntex = 0;

        Arrays.sort(intervals, new Comparator<int []>() {
            @Override
            public int compare(int [] o1, int [] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int i=1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[lastValidIntervalIntex][1]) {
                count++;
            } else {
                //valid and dont have to remove it
                lastValidIntervalIntex = i;
            }
        }

        return count;
        
    }
}