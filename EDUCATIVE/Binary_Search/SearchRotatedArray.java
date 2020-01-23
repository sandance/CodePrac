

class SearchRotatedArray {
    private static int binarySearch(int [] arr, int key, int start, int end) {
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;

            if (key == arr[mid]) {
                return mid;
            }
            
            if (arr[start] < arr[end]) // asending order 
            {
                if ( key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // descen
                if (key > arr[mid]) {
                    end = mid - 1;      
                } else {
                    start = mid + 1;
                }
            }
        }
        return mid;
    }

    public static int search(int[] arr, int key) {
        // TODO: Write your code here
        return binarySearch(arr, key, 0, arr.length - 1);
        
    }

    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }

}