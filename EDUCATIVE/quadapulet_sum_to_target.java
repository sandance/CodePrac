class QuadrupleSumToTarget {
    public static void QuadrupleSumToTarget(int [] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0; i < arr.length - 3; i++) {
            if(i >0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for(int j=i+1; j < arr.length - 2; j++) {
                if( j >0 && arr[j] == arr[j-1]) {
                    continue;
                }
                quad_sort(arr, i, j, result);
            }
            return result;
        }
    }



    public static void quad_sort(int [] arr, int first, int second, List<List<Integer>> result) {
        int left = second + 1;
        int right = arr.length - 1;

        while(left <= right) {

            int comSum = arr[first] + arr[second] + arr[left] + arr[right];
            if (comSum == target) {
                result.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;

                while(left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while(left < right && arr[right] == arr[right + 1]) {
                    right--;
                }

            } else if ( comSum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}