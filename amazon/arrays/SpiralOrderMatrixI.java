package amazon.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixI {
    public int[] spiralOrder(final int[][] A) {
        int[] result = new int[A.length * A[0].length];
        //System.out.println(result.length);
        int left = 0, right = A[0].length - 1, top = 0, bottom = A.length - 1;
        int dir = 0;
        int index = 0;
        while (left <= right && top <= bottom) {
            //System.out.println(index);
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    result[index++] = A[top][i];
                }
                dir = 1;
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    result[index++] = A[i][right];
                }
                dir = 2;
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    result[index++] = A[bottom][i];
                }
                dir = 3;
                bottom--;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = A[i][left];
                }
                dir = 0;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int A[][] = {{1, 2}, {3, 4}, {5, 6}};
        SpiralOrderMatrixI obj = new SpiralOrderMatrixI();
        int result[] = obj.spiralOrder(A);
        for ( int i=0; i<result.length; i++){
            System.out.print(result[i]);
        }
    }
}
