

import java.util.*;

class Interval {

    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};


class MergeIntervals {

    public static List<Interval> mergeInterval (List<Integer> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        List<Internal> mergedIntervals = new LinkedList<>();

        Iterator<Interval> internalPtr = intervals.iterator();
        Internal interval = internalPtr.next();

        int start = interval.start;
        int end  = interval.end;

        while(internalPtr.hasNext()) {
            interval = internalPtr.next();
            if(interval.start <= end) {
                // overlapping interval , adjust the end
                end = Math.max(interval.end, end);
            } else {
                // non overlapping internal
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // add the last interval
        mergedIntervals.add(new Interval(start, end));

    }
}