/*
542. 01 Matrix
Medium
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
Example 1:
Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:
Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]
Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
Note:
    The number of elements of the given matrix will not exceed 10,000.
    There are at least one 0 in the given matrix.
    The cells are adjacent in only four directions: up, down, left and right.
*/
package com.olsh;
class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i=0;i<n;i++)          
            for (int j=0;j<m;j++)
                if (matrix[i][j]>0)matrix[i][j]=10000;       
      
        for (int i=0;i<n;i++)          
            for (int j=0;j<m;j++)
                if (matrix[i][j]>0)changeMatrix(matrix,j,i,n,m);       
        for (int i=n-1;i>=0;i--)          
            for (int j=m-1;j>=0;j--)
                if (matrix[i][j]>0)changeMatrix(matrix,j,i,n,m);

        return matrix;
    }
    
    public void changeMatrix(int[][] matrix, int x, int y, int n, int m){
        if (y>0)matrix[y][x]=Math.min(matrix[y][x],matrix[y-1][x]+1);
        if (x>0)matrix[y][x]=Math.min(matrix[y][x],matrix[y][x-1]+1);
        if (y<n-1)matrix[y][x]=Math.min(matrix[y][x],matrix[y+1][x]+1);
        if (x<m-1)matrix[y][x]=Math.min(matrix[y][x],matrix[y][x+1]+1);
        }
}
