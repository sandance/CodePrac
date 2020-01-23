import java.util.*;

class TaskScheduling {
  public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
    
        int[] inDegree = new int[tasks];
        /* For all edge , find the inDegree of the Graph */
        for (int[] prereq : prerequisites) {
            inDegree[prereq[0]]++;
        }

        Set<Integer> zeroDegree = new HashSet<>();

        for (int i = 0; i < tasks; i++) {
            //System.out.println(inDegree[i]);
            if (inDegree[i] == 0) {
                zeroDegree.add(i);
            }
        }

        while (!zeroDegree.isEmpty()) {
            Iterator<Integer> it = zeroDegree.iterator();
            int course = it.next();
            System.out.print(course+ "\t");
            zeroDegree.remove(course);

            for (int[] prereq : prerequisites) {
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
                return false;
            }
        }

        return true;
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