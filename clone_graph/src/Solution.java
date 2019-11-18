import java.util.HashMap;
import java.util.*;

public class Solution {
    private static Map<Integer, Node> map = new HashMap<>();

    public static Node cloneGraph(Node node) {

        if(node == null)
            return null;
        return clone(node);
    }


    private static Node clone(Node root ){
        Queue<Node> queue = new LinkedList<>();
        Node newRoot = new Node(root.val);
        map.put(root.val, newRoot );
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node u = queue.poll();

            for (Node node : u.neighbors) {
                if(!map.containsKey(node.val)) {
                    queue.offer(node);
                    map.put(node.val, node);
                }
                //newRoot.neighbors.add(node);
                map.get(u.val).neighbors.add(map.get(node.val));
            }

            //at each label
        }
        return newRoot;

    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        int [] nums = new int[n];

        for (int i=0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter the target element");
        int target = sc.nextInt();

        System.out.println("Search Index: " +  find_element(nums, target));



    }
}
