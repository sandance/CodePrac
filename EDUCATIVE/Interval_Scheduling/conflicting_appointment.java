import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class ConflictingAppointment {

    public static boolean canAttendAllAppointment(Interval [] intervals) {
        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for(int i = 1; i < intervals.length; i++) {
            if ( intervals[i].start < intervals[i-1].end){
                return false;
            }
        }

        return true;
    }

}


class IntervalIntersection { 
    public static Interval[] merge ( Interval[] arr1, Interval[] arr2) {

        List<Interval> result = new ArrayList<Interval>();

        int i =0 , j =0;

        while( i < arr1.length && j < arr2.length) {
            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) 
                || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
                    result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }
            // next move from the intervals which is finishing first
            if(arr1[i].start < arr2[j].end) {
                i++;
            } else {
                j++;
            }


            
        }

        return result.toArray(new Interval[result.size()]);

    }

}

