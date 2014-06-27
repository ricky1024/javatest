import java.util.*;
public class MaxPointsOnLine {
	public int maxPoints(Point[] points) {
        if(points==null || points.length==0) return 0;
        if(points.length==1) return 1;
        int result = 0;
        Map<Float, Integer> map = new HashMap<Float, Integer>();
        for(int i = 0; i < points.length; i++) {
            int max = 0;
            int duplicate = 0;
            map.clear();
            for(int j = 0; j < points.length; j++) {
            	if(points[j].x == points[i].x && points[j].y == points[i].y) {
            		duplicate++;
            		continue;
            	}
                float k = points[j].x - points[i].x==0?(float)Integer.MAX_VALUE:(float)(points[j].y - points[i].y)/(points[j].x - points[i].x);
                if(map.containsKey(k)) {
                    map.put(k, map.get(k)+1);
                } else {
                    map.put(k, 1);
                }
            }
            for(int x : map.values()) {
            	max = max>x?max:x;
            }
            result = result>(max+duplicate)? result:(max+duplicate);
        }
        return result;
    }
    public static void main(String[] args) {
    	MaxPointsOnLine m = new MaxPointsOnLine();
    	Point[] points = new Point[2];
    	points[0] = new Point(0,0);
    	points[1] = new Point(0,0);
    	System.out.println(m.maxPoints(points));
    }
}

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}