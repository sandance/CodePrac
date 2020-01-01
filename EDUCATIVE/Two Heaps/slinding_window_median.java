import java.util.*;

class SlidingWindowMedian {

    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private static void rebalanceHeaps() {
        if(maxHeap.size() >  minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }  else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        // TODO: Write your code here

        for(int windowEnd = 0 ; windowEnd < nums.length; windowEnd++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[windowEnd]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }



            rebalanceHeaps();


            if( i - k + 1 >= 0) {
                // if we have at least k elements in the sliding window
                if(maxHeap.size() == minHeap.size()) {
                    // we have even number of elments , take advantage of middle two elements
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }


                // remove elements going out of the sliding window
                int elementToBeRemoved = nums[i - k + 1];

                if(elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }

                rebalanceHeaps();
            }




        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}