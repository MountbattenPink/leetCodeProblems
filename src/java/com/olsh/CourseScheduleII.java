/*
210. Course Schedule II
Medium
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have 
to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the
ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them.
If it is impossible to finish all courses, return an empty array.
Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/
package com.olsh;
import java.lang.Map;
import java.lang.Integer;
import java.lang.List;
import java.lang.ArrayList;
import java.lang.HashMap;
import java.lang.Set;
import java.lang.HashSet;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>>adjacencyList = new HashMap<>();
        for (int i=0;i<numCourses;i++) adjacencyList.put(i, new ArrayList<>());
        for (int[] prereq:prerequisites)adjacencyList.get(prereq[1]).add(prereq[0]);
        Set<Integer>visited = new HashSet<>();
        List<Integer>toposort = new LinkedList<>();
        for (int key:adjacencyList.keySet()) 
            if (toposort(key, toposort, visited, adjacencyList, new HashSet<>()))
                return new int[0];
        int[]res = new int[toposort.size()];
        for (int i=0;i<toposort.size();i++)res[i]=toposort.get(i);
        return res;
        
    }
    public boolean toposort(int key, List<Integer>stack, Set<Integer>visited, Map<Integer,List<Integer>>adjacencyList, Set<Integer>currentVisited){
        if (currentVisited.contains(key))return true;
        boolean b = false;
        if (!visited.contains(key)){
            visited.add(key);
             currentVisited.add(key);
            for (int child: adjacencyList.get(key)){ 
                Set<Integer>newCurrentSet = new HashSet<>();
                newCurrentSet.addAll(currentVisited);
                newCurrentSet.add(key);
                b|=toposort(child, stack, visited, adjacencyList, newCurrentSet);
                if (b) return true;
            }
            stack.add(0,key);
        }
        return false;
    }
    
}
