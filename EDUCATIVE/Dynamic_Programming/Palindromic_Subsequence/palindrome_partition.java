class Palindrome_Partition {

    public int findMPPCuts(String st) {
        return findMPPCutsRecur(st, 0, st.length() - 1);
    }


    private int findMPPCutsRecur(String st, int startIndex, int endIndex) {
        // we dont need to cut the string if it is a palindrome

        if(startIndex >= endIndex || isPalindrome(st, startIndex, endIndex)) 
            return 0;
        // at max we need to cut the String into length - 1 pieces
        int minimumCuts = endIndex - startIndex;

        for(int i=startIndex; i <= endIndex; i++) {
            if(isPalindrome(st, startIndex, i)){
                // we can cut here as we have a palindrome from startIndex to 'i'
                minimumCuts = Math.min(minimumCuts , 1 + findMPPCutsRecur(st, i+1, endIndex));
            }
        }

        return minimumCuts;
    }

    public static boolean isPalindrome(String st, int startIndex, int endIndex) {
        while(startIndex <= endIndex) {
            if (st.charAt(startIndex) != st.charAt(endIndex)) {
                return false;
            } 
            startIndex++;
            endIndex--;
        }
        return true;
    
    }
}