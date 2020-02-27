class solution {
    public static void square_sorted(int [] arr) {
        int left_ptr = 0;
        int right_ptr = 0;
        int[] squares = new int[arr.length];

        while(arr[right_ptr] <= 0) {
            right_ptr++;
        }


        while(right_ptr < arr.length) {
            int leftSquare = arr[left_ptr] * arr[left_ptr];
            int rightSquare = arr[right_ptr] * arr[right_ptr];
            if (leftSquare >= rightSquare) {
                squares[left_ptr] = rightSquare;
                right_ptr++;
            } else {
                squares[left_ptr] = leftSquare;
                left_ptr++;
                
            }
        }
    }
}