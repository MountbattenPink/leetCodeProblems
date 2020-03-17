/*
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
