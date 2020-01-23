import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        if (vertices <= 0) {
            return sortedOrder;
        }
        // initialize the graph
        HashMap<Integer, Integer> inDegree  = new HashMap<>(); 
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list

        for(int i =0; i < vertices ; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }


        // build the graph

        for(int i=0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child  = edges[i][1];

            graph.get(parent).add(child); // put the child into parents list
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // find all sources , all vertices with zero degree
        Queue<Integer> sources = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }


        // For each source , add it 
        while(!sources.isEmpty()) {
            int vertex = sources.poll();

            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for(int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        // graph has a cycle
        if (sortedOrder.size() != vertices) {
            return new ArrayList<>();
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