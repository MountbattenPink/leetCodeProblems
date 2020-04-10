/*
289. Game of Life
Medium
According to the Wikipedia's article: 
"The Game of Life, also known simply as Life, is a cellular automaton devised by the 
British mathematician John Horton Conway in 1970."
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules 
(taken from the above Wikipedia article):
    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. 
The next state is created by applying the above rules simultaneously to every cell in the current state, 
where births and deaths occur simultaneously.
Example:
Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:
    Could you solve it in-place? Remember that the board needs to be updated at the same time: 
    You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, 
    which would cause problems when the active area encroaches the border of the array. How would you address these problems?


*/
class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                int aliveNeighbours = 0;
                    if (j>0)aliveNeighbours += board[i][j-1];
                    if (i>0)aliveNeighbours += board[i-1][j];
                    if (i<board.length-1)aliveNeighbours += board[i+1][j];
                    if (j<board[i].length-1)aliveNeighbours += board[i][j+1];
                    if (j>0 && i>0)aliveNeighbours+=board[i-1][j-1];
                    if (j>0 && i<board.length-1)aliveNeighbours+=board[i+1][j-1];
                    if (i>0 && j<board[i].length-1)aliveNeighbours+=board[i-1][j+1];
                    if (i<board.length-1 && j<board[i].length-1)aliveNeighbours+=board[i+1][j+1];
                
                aliveNeighbours%=10;
                int isAlive=0;
                if (aliveNeighbours<2 || aliveNeighbours>3)isAlive = 0;
                else if (aliveNeighbours==3)isAlive = 1;
                else isAlive = board[i][j];
                board[i][j]+=10*isAlive;
            }
        }
        
        for (int i=0;i<board.length;i++)
           for (int j=0;j<board[i].length;j++)board[i][j]/=10;
    }
}
