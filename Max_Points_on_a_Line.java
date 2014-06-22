/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length == 0) return 0;
        if(points.length == 1) return 1;
        int max = 0;
        for(int i = 0; i < points.length; i++) {
            HashMap<Float, Integer> hm = new HashMap<Float, Integer>();
            int same = 0;
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;
                if(points[i].x == points[j].x && points[i].y == points[j].y) {same++; continue;}
                float slope = ((float)(points[i].y - points[j].y))/(points[i].x - points[j].x);
                if(hm.containsKey(slope))
                    hm.put(slope, hm.get(slope) + 1);
                else
                    hm.put(slope, 2);
            }
            for(float k : hm.keySet()) {
                hm.put(k, hm.get(k) + same);
            }
            for(int v : hm.values()) {
                if(v > max) max = v;
            }
            if(same+1 > max)
                max = same+1;
        }
        return max;
    }
}