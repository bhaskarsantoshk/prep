package amazon.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if ( intervals.size() <= 1 ) return intervals;
        ArrayList<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        Interval interval = new Interval(intervals.get(0).start, intervals.get(0).end);
        for ( int i=1; i<intervals.size(); i++){
            if ( intervals.get(i).start > interval.end){
                result.add(interval);
                interval = intervals.get(i);
            }
            else{
                interval.end = Math.max ( interval.end, intervals.get(i).end);
            }
            if ( i == intervals.size()-1){
                result.add(interval);
            }
        }
        return result;
    }
}
