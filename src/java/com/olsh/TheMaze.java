/*
490. The Maze
Medium
There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up, down, left or right, but it won't stop 
rolling until hitting a wall. When the ball stops, it could choose the next direction.
Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. The start and destination coordinates are 
represented by row and column indexes.

Example 1:
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
Example 2:
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)
Output: false
Explanation: There is no way for the ball to stop at the destination.

Note:

    There is only one ball and one destination in the maze.
    Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
    The given maze does not contain border (like the red rectangle in the example pictures), 
    but you could assume the border of the maze are all walls.
    The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
*/

package com.olsh;
import java.lang.Set;
import java.lang.HashSet;
import java.lang.Deque;
import java.lang.LinkedList;

class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            int source = start[0]*maze[0].length+start[1];
            int dest = destination[0]*maze[0].length+destination[1];
            Set<Integer>visited = new HashSet<>();
            Deque<Integer>queue = new LinkedList<>();
            queue.add(source);
            while (!queue.isEmpty()){
                int vertex = queue.removeFirst();
                if (!visited.contains(vertex)){
                    visited.add(vertex);
                    int vi=vertex / maze[0].length;
                    int vj=vertex % maze[0].length;
                    //up
                    int i=vi;
                    while (i>=0 && maze[i][vj]!=1)i--;
                    if (i+1!=vi)queue.add((i+1)*maze[0].length+vj);
                    //down
                    i=vi;
                    while (i<maze.length && maze[i][vj]!=1)i++;
                    if (i-1!=vi)queue.add((i-1)*maze[0].length+vj);
                    //right
                    int j=vj;
                    while (j<maze[0].length && maze[vi][j]!=1)j++;
                    if (j-1!=vj)queue.add(vi*maze[0].length+j-1);
                    //left
                    j=vj;
                    while (j>=0 && maze[vi][j]!=1)j--;
                    if (j+1!=vj)queue.add(vi*maze[0].length+j+1);
                }
            }        
        return visited.contains(dest);
    }
}
