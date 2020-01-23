import java.util.*;

class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        //List<Integer> topNumbers = new ArrayList<>(k);
        // TODO: Write your code here

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1 );
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((o1,o2) ->  o1.getValue() - o2.getValue());
        
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // create a list of top k elements
        List<Integer> topNumbers = new ArrayList<>(k);
        while(!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }
        


        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
