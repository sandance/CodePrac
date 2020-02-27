

//tutorial

// bruth force approach

/*
Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

*/

class Solution {
    static int maxSum(int arr[], int n, int k) {
        int max_sum = Integer.MAX_VALUE;
        int sum =0;

        for(int i=0; i <n-k; i++) {
            int current_sum = 0;
            for(int j=0; j < k; j++) {
                current_sum = current_sum + arr[i+j];
            }

            max_sum = Math.max(max_sum, current_sum);

        }

        return max_sum;
    }

    // sliding window solution

    static int maxSum_window(int arr[], int n, int k) {
        if ( n  < k) {

            return -1;
        }

        int max_sum = 0;
        // initial window
        for(int i=0; i < k; i++) {
            max_sum += arr[i];
        }

        
        int window_sum = max_sum;

        for(int i=k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

         return max_sum;
        
    }

}


