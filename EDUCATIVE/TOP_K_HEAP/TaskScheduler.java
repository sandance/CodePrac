import java.util.*;

class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        // TODO: Write your code here
        int intervalCount = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());

        maxHeap.addAll(freqMap.entrySet());

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            //Map.Entry<Character, Integer> entry = maxHeap.poll();

            int n = k + 1;
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();

            for(; n > 0 && !maxHeap.isEmpty(); n--) {
                intervalCount++;
                Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

                if (currentEntry.getValue () > 1) {
                    currentEntry.setValue(currentEntry.getValue() - 1);
                    waitList.add(currentEntry);
                }
            }

            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty()) {
                intervalCount += n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }
}
