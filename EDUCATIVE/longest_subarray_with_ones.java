import java.util.HashMap;

class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
      // TODO: Write your code here

      int windowStart = 0; 
      int maxLen = 0, maxCount = 0;
      HashMap<Integer, Integer> freqMap = new HashMap<>();

      for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
          int rightDigit = arr[windowEnd];
          freqMap.put(rightDigit, freqMap.getOrDefault(rightDigit, 0) + 1);
          maxCount = Math.max(maxCount, freqMap.get(rightDigit));

          while(windowEnd - windowStart + 1 - maxCount > k) {
              int leftChar = arr[windowStart];
              freqMap.put(leftChar, freqMap.get(leftChar) - 1);
              windowStart++;
          }

          maxLen = Math.max(maxLen , windowEnd - windowStart + 1);

      }
      return maxLen;
    }
  }


  