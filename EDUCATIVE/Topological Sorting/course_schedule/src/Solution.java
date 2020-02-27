import java.io.*;
import java.util.*;

public class Solution {

    /*
     Algorithm to check the output:
     L ← Empty list that will contain the sorted elements
     S ← Set of all nodes with no incoming edges
     while S is non-empty do
        remove a node n from S
        add n to tail of L
        for each node m with an edge e from n to m do
            remove edge e from the graph
            if m has no other incoming edges then
                insert m into S
     if graph has edges then
        return error (graph has at least one cycle)
     else
        return L (a topologically sorted order)
     */

    public static boolean course_schedule(int numCourses, int [][] prerequisites) {

        int [] inDegree = new int[numCourses];
        /* For all edge , find the inDegree of the Graph */
        for(int [] prereq : prerequisites) {
            inDegree[prereq[0]]++;
        }

        Set<Integer> zeroDegree = new HashSet<>();

        for(int i=0 ; i < numCourses; i++) {
            System.out.println(inDegree[i]);
            if(inDegree[i] == 0) {
                zeroDegree.add(i);
            }
        }


        while(!zeroDegree.isEmpty()) {
            Iterator<Integer> it = zeroDegree.iterator();
            int course = it.next();
            System.out.println(course);
            zeroDegree.remove(course);

            for(int [] prereq : prerequisites) {
                if(prereq[1] == course) {
                    //remove that edge from
                    inDegree[prereq[0]]--;
                    if(inDegree[prereq[0]]==0){
                        zeroDegree.add(prereq[0]);
                    }

                }
            }
        }

        for (int i : inDegree){
            if ( i != 0) {
                return false;
            }
        }

        return true;

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
        System.out.println("Search Index: " +  course_schedule(n, data));
    }
}
