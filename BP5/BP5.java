//Problem Statement

// In a GPS navigation system, Given a set of points,
// the closest-pair problem is to find the two points that are nearest to each other.

public class BP5 {
    public static void main(String[] args) {
        Point[] points = new Point[] {
            new Point(5.0f, 1.0f), new Point(1.0f, 0.0f),
            new Point(2.0f, 0.0f), new Point(1.0f, 1.0f),
            new Point(2.5f, 2.0f), new Point(3.0f, 2.0f)
        };

        int i1 = -1, i2 = -1;  
        float min = 1f / 0f;
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                float dist = points[i].distance(points[j]);
                if(dist < min) {
                    min = dist;
                    i1 = i;
                    i2 = j;
                }
            }
        }

        System.out.println(
            "Closest Points are: " +
            "A: " + points[i1] + ", B: " + points[i2]
        );
    }
}

class Point {
    private float x, y;

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public float mag() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public float distance(Point p) {
        return (float)Math.abs(mag() - p.mag());
    }

    @Override
    public String toString() {
        return "(x: " + x + ", y: " + y + ")";
    }
}