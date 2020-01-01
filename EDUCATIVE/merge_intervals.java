import java.awt.List;
import java.util.Iterator;

class Interval {
    int start ;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end  = end;
    }
}





class Solution {

    /* Problem Statement:

    Intervals: [[6,7], [2,4], [5,9]]
    Output: [[2,4], [5,9]]
    Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
    */

    public static List<Interval> merge (List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();

        if(intervals.size() < 2) {
            return intervals;
        }

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        Iterator<Interval> intervalPtr = intervals.iterator();
        Internal interval = intervalPtr.next();

        int start = interval.start;
        int end  = interval.end;

        while(intervalPtr.hasNext()) {
            interval = intervalPtr.next();
            if(interval.start <= end) {
                // overlapping intervals, adjust the end
                end = Math.max(interval.end, end);
            } else {
                // non-overlapping interval, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }

            mergedIntervals.add(new interval(start, end));


        }
        

        return mergedIntervals;
    } 


}