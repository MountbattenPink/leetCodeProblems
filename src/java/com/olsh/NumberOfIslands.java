package com.olsh;/*
200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

import java.util.*;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
	Map<Integer, Set<List<Integer>>> separateIslands = new HashMap<>();
	for (int i=0;i<grid.length;i++){
		for (int j=0;j<grid[0].length;j++){
			if (grid[i][j]=='1'){
				int previousIsland = -1;
				boolean separateIsland = true;
				Iterator<Integer> it = separateIslands.keySet().iterator();
				while(it.hasNext()){
					Integer island = it.next();
					if (separateIslands.get(island).contains(Arrays.asList(i-1,j)) ||
					separateIslands.get(island).contains(Arrays.asList(i,j-1)))
					{
						separateIsland = false;
						separateIslands.get(island).add(Arrays.asList(i,j));
						if (previousIsland!=-1){
						separateIslands.get(previousIsland).addAll(separateIslands.get(island));
						it.remove();
						} else previousIsland = island;
					}	
				}
				if (separateIsland){
					Set<List<Integer>>points = new HashSet();
					points.add(Arrays.asList(i,j));
					separateIslands.put(i*100+j, points);
					}
			}
		}
       }
       return separateIslands.size();
    }
}
