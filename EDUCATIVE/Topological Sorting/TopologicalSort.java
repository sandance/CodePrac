import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        int[] inDegree = new int[vertices];
        /* For all edge , find the inDegree of the Graph */
        for (int[] prereq : edges) {
            inDegree[prereq[0]]++;
        }

        Set<Integer> zeroDegree = new HashSet<>();

        for (int i = 0; i < vertices; i++) {
            // System.out.println(inDegree[i]);
            if (inDegree[i] == 0) {
                zeroDegree.add(i);
            }
        }

        while (!zeroDegree.isEmpty()) {
            Iterator<Integer> it = zeroDegree.iterator();
            int course = it.next();
            System.out.print(course + "\t");
            zeroDegree.remove(course);

            for (int[] prereq : edges) {
                if (prereq[1] == course) {
                    // remove that edge from
                    inDegree[prereq[0]]--;
                    if (inDegree[prereq[0]] == 0) {
                        zeroDegree.add(prereq[0]);
                    }

                }
            }
        }

        for (int i : inDegree) {
            if (i != 0) {
                return new ArrayList<>();
            }
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}