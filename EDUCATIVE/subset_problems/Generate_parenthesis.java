import java.util.*;


class ParenthesesString {
    String str;
    int openCount; // open parenthesis count
    int closeCount; // close parenthesis count

    public ParenthesesString(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

class GenerateParentheses {

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        // TODO: Write your code here
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));

        while(!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();

            if(ps.openCount == num && ps.closeCount ==  num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num) {
                    queue.add(new ParenthesesString(ps.str + "(" , ps.openCount + 1, ps.closeCount));
                }

                if (ps.openCount > ps.closeCount) {
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
                }
            }

        }


        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
