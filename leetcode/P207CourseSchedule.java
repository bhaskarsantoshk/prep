package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        ArrayList<Integer>[] G = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            G[i] = new ArrayList<>();
        }
        for ( int[] e: prerequisites){
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i =0; i<numCourses; i++){
            if ( degree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while ( !queue.isEmpty() ){
            int c = queue.poll();
            count++;
            for ( int j: G[c]){
                if ( --degree[j] == 0){
                    queue.add(j);
                }
            }
        }
        return count == numCourses;
    }
}
