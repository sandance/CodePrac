import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    // TODO: Write your code here
    List<Integer> result = new ArrayList<>();

    Arrays.sort(arr);
    for(int i=0; i < arr.length; i++) {
        if(i > 0 && arr[i] == arr[i-1]) {
            continue;
        }
        int minsum = Integer.MAX_VALUE;
       
        int left = 0; int right = arr.length - 1;
        while(left < right) {
            int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
            if(targetDiff == 0) {
                return targetSum - targetDiff;
            }

            if(Math.abs(targetDiff) < Math.abs(minsum) || (Math.abs(targetDiff) == Math.abs(minsum) && targetDiff > minsum)) {
                minsum = targetDiff;
            }

            if(targetDiff > 0) {
                left++;
            } else {
                right--;
            }
        }

        return targetSum - minsum;
  }
}