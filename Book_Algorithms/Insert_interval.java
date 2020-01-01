import java.util.ArrayList;

class Solution {

    public int [][] insert (int [][] intervals, int [] newInterval) {

        for(int i=0; i < intervals.length; i++) {
            if(intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else if (intervals[1][0] < newInterval[1]) {
                result.add()
            }
        }
    }


    public static List<Interval> insert (List<Interval> intervals, Interval newIterval) {
        List<Interval> result = new ArrayList<>();

        int i =0;

        while(i < intervals.size() && intervals.get(i).end < newIterval.start){
            result.add(intervals.get(i));
        }

        while(i < intervals.size() && intervals.get(i).start < newIterval.end ) {
            //merge interval
            result.add(new Interval(Math.min(intervals.get(i).start, newIterval.start), 
                Math.max(intervals.get(i).end, newIterval.end)));
            
            i++;

        }

        while( i < intervals.size()){
            result.add(intervals.get(i++));
        }

        return result;
    }
}



