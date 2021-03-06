class Solution {
    public String reverseWords(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        String [] tempStr = s.split(" ");

        for(String st : tempStr) {
            char[] temp = st.toCharArray();
            reverse(temp);
            stringBuilder.append(temp).append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();

    }

    public void reverse(char [] temp) {
        int i=0;
        int j = temp.length - 1;

        while(i < j && i != j) {
            char t = temp[i];
            temp[i++] = temp[j];
            temp[j--] = t;
        }
    }
}