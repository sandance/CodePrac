import java.awt.List;
import java.util.PriorityQueue;

class Meeting {
    int start;
    int end;

    public Meeting(int start , int end) {
        this.start = start;
        this.end = end;
    }
}

class Meeting_Room_Schedule {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0) {
            return 0;
        }

        int minRooms = 0;

        Collections.sort(meetings, (a,b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Meeting> minHeap = new PriorityQueue<Meeting>(meetings.size, (a,b) -> Integer.compare(a.end, b.end) );

        for(Meeting meeting : meetings) {
            while(!minHeap.isEmpty() && meeting.start > minHeap.peek().end){
                minHeap.poll();
            }
            // add current meeting into the heap
            minHeap.offer(meeting);

            minRooms = Math.max(minRooms, minHeap.size());
        }

        return minRooms;

    }

}