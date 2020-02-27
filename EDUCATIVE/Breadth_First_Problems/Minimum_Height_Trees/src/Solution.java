import java.io.*;
import java.util.*;


public class Solution {

    public static List<Integer> minimum_height(int n, int [][] edges) {
        List<Set<Integer>> graph = new ArrayList<>(n);

        List<Integer> result = new LinkedList<>();

        if (edges.length == 0 || edges == null)
            return result;

        if(n==1)
            return Collections.singletonList(0);

        for (int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leafs = new ArrayList<>();

        for(int i=0 ; i < graph.size(); i++) {
            if (graph.get(i).size() ==1 ) {
                leafs.add(i);
            }
        }

        /* use leaf nodes to go up */

        while(n > 2){
            n -= leafs.size();
            List<Integer> newLeaves = new ArrayList<>();

            for( int i : leafs) {
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if(graph.get(i).size() == 1) {
                    newLeaves.add(j);
                }
                leafs = newLeaves;
            }

        }

        return leafs;

    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();

        int [][] data = new int[n][2];

        for (int i=0; i < n; i++) {
            //nums[i] = sc.nextInt();
            for(int j=0; j < 2; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        System.out.println("Search Index: " + minimum_height(n, data));
    }
}
