class Solution {
    private static final int [] coins = new int [] {25,10,5,1};
    // bruth force solution
    public int make_Change(int c) {
        if (c==0) return 0;

        int minCoins = Integer.MAX_VALUE;

        for ( int coin : coins) {
            int curMinCoins = make_Change(c - coin);

            if(curMinCoins < minCoins) {
                minCoins = curMinCoins;
            }
        }
        return minCoins + 1;
    }
}


// Top Down solution

class Solution {
    private static final int [] coins = new int [] {25,10,5,1};
    // bruth force solution

    public int make_change(int c) {
        //if (c == 0) return 0;
        int [] cache = new int [c + 1];
        for(int i=0; i < c + 1; i++) {
            cache[i] = -1;
        }
        return make_Change(c, cache);
    }
    public int make_Change(int c, int [] cache) {
        if (cache[c] >= 0) return cache[c];

        int minCoins = Integer.MAX_VALUE;

        for ( int coin : coins) {
            if ( c - coin >= 0) {
                int curMinCoins = make_Change(c - coin, cache);

                if(curMinCoins < minCoins) {
                    minCoins = curMinCoins;
                }
            }
        }


        cache[c] = minCoins + 1;
        return cache[c];
    }
}


// Bottom-up approach

class Solution {
    private static final int [] coins = new int [] {25,10,5,1};
    // bruth force solution

    public int make_Change(int c) {
        int [] cache = new int [c+1];

        for(int i=1; i <= c; i++) {
            int minCoins = Integer.MAX_VALUE;
            for ( int coin : coins) {
                if ( i - coin >= 0) {
                    int curMinCoins = make_Change(i - coin) + 1;
                    if(curMinCoins < minCoins) {
                        minCoins = curMinCoins;
                    }
                }
            }

            cache[i] = minCoins;

        }
        return cache[c];
    }
}


