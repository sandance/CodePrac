import java.util.*;

class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        // TODO: Write your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int distinctElementCount = 0;

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>( (o1, o2)->o1.getValue() - o2.getValue());

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() > 1) {
                minHeap.add(entry);
            } else {
                distinctElementCount++;
            }
        }

        while( k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            // to make a element distinct we need to make all of its occurances except one
            k -= entry.getValue() - 1;

            if(k >= 0) {
                distinctElementCount++;

            }
        }

        if ( k > 0) {
            // remove some distinct elements
            distinctElementCount -= k;
        }

        // 
        return distinctElementCount;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}