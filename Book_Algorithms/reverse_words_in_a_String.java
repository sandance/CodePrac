import java.util.ArrayDeque;
import java.util.Deque;



class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)
            return "";

        Deque<String> queue = new ArrayDeque<>();

        String [] words = s.split(" ");

        for (String word : words) {
            if(!word.equals(" ")) {
                queue.offer(word);
            }
            
        }

        StringBuilder stringBuilder = new StringBuilder();

        while(!queue.isEmpty()) {
            stringBuilder.append(queue.pollLast()).append(" ");
        }

        return stringBuilder.substring(0, stringBuilder.length() -1).toString();
    }
}