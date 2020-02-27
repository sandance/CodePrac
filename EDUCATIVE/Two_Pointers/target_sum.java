import java.util.HashMap;

class solution {
    public static int [] targetSum (int [] arr, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for( int item :  arr) {
            map.put(item, i);
        }

        for(int i=0; i < arr.length; i++ ) {
            int second = targetSum - arr[i];
            if(map.containsKey(second)){
                return new int[] { i, map.get(second) };
            }
        }

        return new int[] {-1, -1};
    }
}