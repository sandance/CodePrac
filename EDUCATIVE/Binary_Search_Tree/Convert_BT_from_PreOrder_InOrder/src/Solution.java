import java.io.*;
import java.util.*;


public class Solution {

    private static TreeNode buildTree(int [] preOrder, int preStart, int preEnd, int [] inOrder,
                                  int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {
        if(preStart> preEnd ||  inEnd > inStart)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        // find the index of that node in Inordermap

        int inRoot = inOrderMap.get(preOrder[preStart]);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preOrder, preStart + 1, preStart + numsLeft,
                inOrder, inStart, inRoot -1, inOrderMap);

        root.right = buildTree(preOrder, preStart + numsLeft + 1, preEnd, inOrder,
                inRoot + 1, inEnd, inOrderMap);

        return root;
    }

    public static TreeNode buildTree(int [] preOrder, int [] inOrder) {

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i =0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i] , i);
        }

        return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length -1, inOrderMap);

    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        int [] preOrder = new int[n];
        int [] inOrder = new int [n];

        for (int i=0; i < n; i++) {
            preOrder[i] = sc.nextInt();
            inOrder[i] = sc.nextInt();
        }



        System.out.println("Search Index: " +  buildTree(preOrder, inOrder));



    }
}
