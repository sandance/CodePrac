import java.util.*;

class RearrangeString {

  public static String rearrangeString(String str) {
    // TODO: Write your code here

    // find the frequency of items
    HashMap<Character, Integer> hashMap = new HashMap<>();

    for(char ch : str.toCharArray()) {
        hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>> ((o1,o2) -> o2.getValue() - o1.getValue());

   
    maxHeap.addAll(hashMap.entrySet());
    

    // iterate over the frequency and use stringBuilder to create loop 
    // of characters 

    // add all elements with zero frequency , a can be used

    Map.Entry<Character, Integer> previousEntry = null;
    StringBuilder resultString = new StringBuilder(str.length());

    while(!maxHeap.isEmpty()) {
        Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

        // add the previous entry back into the maxHeap
        if(previousEntry != null && previousEntry.getValue() > 0) {
            maxHeap.offer(previousEntry);
        }
        resultString.append(currentEntry.getKey());
        currentEntry.setValue(currentEntry.getValue() - 1);
        previousEntry = currentEntry;

    }

    return resultString.length() == str.length() ? resultString.toString() : "";
  }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
