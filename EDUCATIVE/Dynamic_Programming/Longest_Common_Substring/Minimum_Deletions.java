
class Minimum_Deletions {
    public static void minimum_deletions_LCS(String s1, String s2) {
        int c1 = findLCS(s1, s2, 0, 0);
        System.out.println("Minimum Deletions needed: " + (s1.length() - c1));
        System.out.println("Minimum Insertions needed: " + (s2.length() - c1));

        System.out.println("Minimum Deletions or insertions needed: " + Math.min((s1.length() - c1), (s2.length() -c1)));
        

    }

    public static int findLCS(String s1, String s2, int i, int j) {
        if(i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + findLCS(s1, s2, i+1, j+1);
        }

        int c1 = findLCS(s1, s2, i+1, j);
        int c2 = findLCS(s1, s2, i, j+1);

        return Math.max(c1, c2);
    }

    public static void main(String [] args) {
        Minimum_Deletions mdi = new Minimum_Deletions();
        mdi.minimum_deletions_LCS("abc", "fbc");
        mdi.minimum_deletions_LCS("abdca", "cbda");
        mdi.minimum_deletions_LCS("passport", "ppsspt");
    }
}