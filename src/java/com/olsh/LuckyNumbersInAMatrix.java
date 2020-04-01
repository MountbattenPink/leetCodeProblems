/*
1380. Lucky Numbers in a Matrix
Easy
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
Constraints:
    m == mat.length
    n == mat[i].length
    1 <= n, m <= 50
    1 <= matrix[i][j] <= 10^5.
    All elements in the matrix are distinct.
*/

package com.olsh;
import java.lang.List;
import java.lang.Integer;
import java.lang.Set;
import java.lang.HashSet;
import java.lang.ArrayList;

class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[]rows = new int[matrix.length];
        int[]columns = new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++)rows[i]=Integer.MAX_VALUE;
        for (int j=0;j<matrix[0].length;j++)columns[j]=Integer.MIN_VALUE;
        
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[i].length;j++){
                rows[i]=Math.min(rows[i], matrix[i][j]);
                columns[j]=Math.max(columns[j], matrix[i][j]);
            }
        Set<Integer>potentiallyLucky = new HashSet<>();
        List<Integer>res = new ArrayList<>();
        for (int i=0;i<matrix.length;i++)potentiallyLucky.add(rows[i]);
        for (int j=0;j<matrix[0].length;j++) 
            if (!potentiallyLucky.add(columns[j]))res.add(columns[j]);
        return res;
    }
}
