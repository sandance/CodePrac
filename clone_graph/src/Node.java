import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;

    List<Node> neighbors;

    Node(int x) {
        val = x;
        neighbors = new ArrayList<Node>();
    }
}
