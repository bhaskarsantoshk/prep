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
    }

    private void swap(Point start, Point end) {
        double x = start.x ;
        double y = start.y ;
        start.setLocation(end.x, end.y);
        end.setLocation(x, y);
    }
}
