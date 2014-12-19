/**
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

        For example,
        Given the following matrix:

        [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
        ]

        You should return [1,2,3,6,9,8,7,4,5].
 **/

/**
 * The idea is to treat the matrix as a series of layers, top-right layers and bottom-left layers. To print the matrix spirally we can peel layers from these matrix, print the peeled part and recursively call the print on the left over part. The recursion terminates when we don't have any more layers to print.

 Input matrix:

 1 2 3 4
 5 6 7 8
 9 0 1 2
 3 4 5 6
 7 8 9 1

 After peeling top layer:

  1 2 3
       4
 5 6 7 8
 9 0 1 2
 3 4 5 6
 7 8 9 1

 After peeling right layer:

        4
 5 6 7  8
 9 0 1  2
 3 4 5  6
 7 8 9 1

 After peeling bottom layer from matrix:

 5 6 7
 9 0 1
 3 4 5
 7
   8 9 1

 After peeling right layer from matrix:

 5   6 7
 9   0 1
 3   4 5
 7

 After peeling top layer from sub-matrix:

  6
    7
 0  1
 4  5

 After peeling right layer from sub-matrix:

     7
 0   1
 4 5

 After peeling bottom layer from sub-matrix:

 0
 4   5

 After peeling right layer from sub-matrix:

 0
 4

 Recursion terminates.
 */
import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,2},
                {4,5},
                {7,8}};
        System.out.printf("d1=%d, d2=%d\n", arr.length, arr[0].length);
        System.out.println(spiralOrder(arr));
    }

    public static List<Integer> spiralOrder(int[][] arr) {
        List<Integer> res = new ArrayList<Integer>();
        spiralOrderR(arr, 0, 0, arr.length-1, arr[0].length-1, res);
        return res;
    }

    // x1, y1, x2, y2 means the sub matrix to display -- the part [x1 : x2, y1 : y2]
    public static void spiralOrderR(int[][] arr,int x1, int y1, int x2, int y2, List<Integer> res) {
        if(x1 == x2 && y1 == y2) {
            res.add(arr[x1][y1]);
            return;
        }
        if(x1 == x2 && y1 < y2) {
            for(int j = y1; j <= y2; j++)   res.add(arr[x1][j]);
            return;
        }
        if(x1 < x2 && y1 == y2) {
            for (int i = x1; i <= x2; i++) res.add(arr[i][y1]);
            return;
        }

        // display the top layer
        for(int j = y1; j <= y2-1; j++)     res.add(arr[x1][j]);
        // display the right layer
        for(int i = x1; i <= x2-1; i++)     res.add(arr[i][y2]);
        // display the bottom layer
        for(int j = y2; j >= y1+1; j--)     res.add(arr[x2][j]);
        // display the left layer
        for(int i = x2; i >= x1+1; i--)     res.add(arr[i][y1]);

        /** if the shape of sub matrix is like (2*n) or (n*2)
         *  x11 x12 ... x1n
         *  x21 x22 ... x2n
         *  or
         *  x11 x12
         *  x21 x22
         *  ... ...
         *  xn1 xn2
         *  then the matrix has been already displayed, so terminate recursive.
         */
        if(x1 + 1 == x2 || y1 + 1 == y2)    return;

        // display the inner layer sub matrix
        spiralOrderR(arr, x1+1, y1+1, x2-1, y2-1, res);
    }
}
