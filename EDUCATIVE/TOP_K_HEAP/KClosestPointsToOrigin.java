import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}

class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
        //ArrayList<Point> result = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<Point>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
        // TODO: Write your code here

        for(int i=0; i < k; i++) {
            pq.offer(points[i]);
        }

        for(int i=k; i < points.length; i++) {
            if(points[i].distFromOrigin() < pq.peek().distFromOrigin()) {
                pq.poll();
                pq.add(points[i]);
            }
        }
        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}
