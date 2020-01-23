import java.util.*;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        // TODO: Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a - b));
        int cost = 0;
        for(int rlength : ropeLengths) {
            minHeap.offer(rlength);
        }

        while(minHeap.size() >= 2) {
            int sum = minHeap.poll() + minHeap.poll();
            minHeap.add(sum);
            cost += sum;
        }

        return cost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
