package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[] = new int[numCourses];
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] G = new ArrayList[numCourses];
        for ( int i=0; i<numCourses; i++){
            G[i] = new ArrayList<>();
        }
        for ( int[] edge : prerequisites){
            G[edge[1]].add(edge[0]);
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<numCourses; i++){
            if ( indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while ( !queue.isEmpty() ){
            int c = queue.poll();
            res[count++] = c;
            for ( int j: G[c]){
                if ( --indegree[j] == 0){
                    queue.add(c);
                }
            }
        }
        return count== numCourses ? res: new int[0] ;
    }
}
