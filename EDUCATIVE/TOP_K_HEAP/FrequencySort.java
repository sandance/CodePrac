import java.util.*;

class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        // TODO: Write your code here

        char [] chars = str.toCharArray();
        HashMap<Character, Integer> freqSort = new HashMap<>();

        for(char ch : chars) {
            freqSort.put(ch, freqSort.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());

        for(Map.Entry<Character, Integer> entry: freqSort.entrySet()) {
            maxHeap.add(entry);
        }

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            int count = maxHeap.peek().getValue();
            while(count > 0) {
                result.append(maxHeap.peek().getKey());
                count--;
            }
            maxHeap.poll();
        }

       
        return result.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
