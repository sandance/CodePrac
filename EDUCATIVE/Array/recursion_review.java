// Count number of digits in a number

class solution {
    public static int count_didit_iter(int num) {
        int last_digit =0, count=0;
        while(num !=0) {
            last_digit = num % 10;
            count++;
            num = num / 10;
        }
    }

    int count =0;
    public static int count_recur(int num) {
        
        // base case
        

        if (num <= 1) {
            return 1;
        }

        count += count_recur(num / 10);
    }
}


class ListNode {
    int val;
    ListNode next;
}

class Linked {
    public static lenLinked(ListNode root) {
        while(root.next ! =){
            count++;
            root = root.next;
        }
    }

    public static int rec_linked(ListNode root) {
        if(root == null) {
            return 1;
        }

        count += rec_linked(root.next);
    }
}