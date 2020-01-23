class FindRange {

    public static int search(int [] arr, int key, boolesn findMaxIndex ) {
        int keyIndex = -1;
        int start = 0, end = arr.length - 1;

        while( start <= end) {
            int mid = start + (emd - start) /2;
            if (key < arr[mid]) {
                end = mid -1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                // equal
                keyIndex = mid;
                if(findMaxIndex) {
                    // look ahead 
                    start = mid + 1; 
                } else {
                    end = mid - 1;
                }



            }
        }
        return keyIndex;
    }

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        // TODO: Write your code here
        result[0] = search(arr, key, false);

        if(result[0] != -1) {
            result[1] = search(arr, key, true);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}