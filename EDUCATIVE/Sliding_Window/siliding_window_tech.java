class Solution {

    public static double [] findAverages(int [] arr, int k) {
        double [] result = new double[arr.length - k + 1];

        double windowSum = 0;
        double windowStart =0;

        for(int windowEnd=0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k -1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return result;
    }
}

// max sum subarray of size k

class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
      // TODO: Write your code here
      int windowStart  =0; 
      int windowSum = 0; int maxSum  =0;
      for(int windowEnd=0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {               
                maxSum = Math.max(windowSum, maxSum );
                windowSum -= arr[windowStart];
                windowStart++; 
            }
            
        }
        
      

      return maxSum;
    }
}


//smallest subarray with a given sum

/*
Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].


*/

class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
      // TODO: Write your code here

      int windowStart = 0;
      int windowSum = 0;
      int minIndex = 0;

      for(int windowEnd=0; windowEnd < arr.length; windowEnd++) {
          windowSum += arr[windowEnd];
          if(windowSum == S) {
              minIndex = Math.max(minIndex , windowEnd - windowStart);
              windowStart++;
              windowSum -= arr[windowStart];
          }
          //windowSum -= arr[windowStart];
          //
      }
      return -1;
    }
  }


