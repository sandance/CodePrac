import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        // TODO: Write your code here

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0 ; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {

            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            graph.get(parent).add(child);
            inDegree.put(i, inDegree.get(key) + 1);
        }

        Queue<Integer> zeroDegree = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue()== 0) {
                zeroDegree.add(entry.getKey());
            }
        }

        while(!zeroDegree.isEmpty()) {
            int prereq = zeroDegree.poll();

            sortedOrder.add(prereq);
            List<Integer> children = graph.get(prereq);

            for(int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    zeroDegree.add(child);
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {

        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}