package ctci.C8RecursionAndDynamicProgramming;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RobotInAGrid {
    ArrayList<Point> getPath(boolean [][] maze){
        if ( maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if ( getPath(maze, maze.length-1, maze[0].length-1, path, failedPoints)){
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if ( row < 0 || col < 0 || !maze[row][col]){
            return false;
        }
        Point p = new Point(row, col);
        if ( failedPoints.contains(p)){
            return false;
        }
        boolean isAtOrigin = ( row == 0) && ( col == 0);
        if ( isAtOrigin || getPath(maze, row, col-1, path, failedPoints) || getPath(maze, row-1, col, path, failedPoints)){
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }


    ArrayList<Point> getPathMmeoized(boolean [][] maze){
        if ( maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashMap<Point, Boolean> cache = new HashMap<>();
        if ( getPathMemoized(maze, maze.length-1, maze[0].length-1, path, cache)){
            return path;
        }
        return null;
    }

    private boolean getPathMemoized(boolean[][] maze, int row, int col, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
        if ( col < 0 || row < 0 || !maze[row][col]){
            return false;
        }
        Point p = new Point(row, col);

        if ( cache.containsKey(p)){
            return cache.get(p);
        }
        boolean isAtOrigin = ( row == 0) && ( col == 0);
        boolean success = false;

        if ( isAtOrigin || getPathMemoized(maze, row, col-1, path, cache) || getPathMemoized(maze, row-1, col, path, cache)){
            path.add(p);
            success = true;
        }
        cache.put(p, success);
        return success;
    }
}
