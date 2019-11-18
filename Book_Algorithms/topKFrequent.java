import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> (o2.getValue() - o1.getValue()));

        //queue.add(map);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry.getKey());
        }

        while(--k) {
            result.add(queue.poll());
        }

        return result;
    }
}