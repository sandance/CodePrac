class minimum_coin_change {

    public static int minimum_coin_change(int [] denominations, int total) {
        int result = minimum_coin_recursive(denominations, total, 0);
        return result;
    }

    public static int minimum_coin_recursive(int [] denominations, int total, int currentIndex) {
        if(total == 0) {
            return 0;
        }

        if(denominations.length == 0 || currentIndex >= denominations.length){
            return Integer.MAX_VALUE;
        }
        
        int count1 = Integer.MAX_VALUE;
        if(denominations[currentIndex] <= total) {
            int res = minimum_coin_recursive(denominations, total - denominations[currentIndex], currentIndex);
        }
        if( res != Integer.MAX_VALUE) {
            count1 = res + 1;
        }

        
    }
}