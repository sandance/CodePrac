import java.io.*;
import java.util.ArrayList;
import java.util.*;


public class Solution {

    public static int [][] tc;
    public static List<Integer> [] graph;

    public static void transitive_closure(List<Integer> [] graph, int V, int E) {
        /*
        Traversal starting all vertices one by one
         */
        for(int i=0; i < V; i++) {
            DFSUtil(i,i);
        }

        for(int i=0; i < V; i++) {
            System.out.println(Arrays.toString(tc[i]));
        }

    }

    private static void DFSUtil(int s, int v) {
        tc[s][v] = 1;

        for( int adj : graph[v] ) {
            if(tc[s][adj] == 0) {
                DFSUtil(s, adj);
            }
        }
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of Vertices and Edges");
        int V = sc.nextInt();
        int E = sc.nextInt();

        graph = new List[V];

        for (int i=0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // add the edges

        for(int i=0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b); // directed graph
        }



        tc = new int[V][V];

        for(int i=0; i <V; i++) {
            Arrays.fill(tc[i], 0);
        }

        transitive_closure(graph, V, E);



    }
}
