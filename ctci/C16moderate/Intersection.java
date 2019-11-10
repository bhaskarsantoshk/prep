package ctci.C16moderate;

public class Intersection {
    class Point{
        double x, y;
        Point (double x , double y){
            x = x;
            y = y;
        }

        public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public Point intersection(Point start1, Point end1, Point start2, Point end2){
        // Ordering
        if ( start1.x > end1.x){
            swap(start1, end1);
        }
        if ( start2.x > end2.x ){
            swap(start2, end2);
        }
        if ( start1.x > start2.x){
            swap(start1, start2);
            swap(end1, end2);
        }

        //Compute Lines
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if ( line1.slope == line2.slope ){
            if ( line1.yintercept == line2.yintercept && isBetween ( start1, start2, end1)){
                return start2;
            }
            return null;
        }

        // Get intersection
        // y = m1x + c1, y = m2x + c2 == > x = ( c2-c1)/ (m1-m2)
        double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
        // y = x * m + c
        double y =  x * line1.slope + line1.yintercept;

        Point intersection = new Point(x, y);

        if ( isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)){
            return intersection;
        }
        return null;
    }

    private boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    private boolean isBetween(double start, double middle, double end) {
        if ( start > end ){
            return end <= middle && middle <= start;
        }
        else{
            return start <= middle && middle <= end;
        }
    }

    class Line{
        double slope, yintercept;
        Line ( Point start, Point end ){
            double deltaX = end.y - start.y;
            double deltaY = end.x - start.x;
            slope = deltaY/deltaX;
            yintercept = end.y - slope * end.x;
        }
    }

    private void swap(Point start, Point end) {
        double x = start.x ;
        double y = start.y ;
        start.setLocation(end.x, end.y);
        end.setLocation(x, y);
    }
}
