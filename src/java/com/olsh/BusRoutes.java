/*
815. Bus Routes
Hard
We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. 
For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) 
travels in the sequence 1->5->7->1->5->7->1->... forever.
We start at bus stop S (initially not on a bus), and we want to go to bus stop T. 
Travelling by buses only, what is the least number of buses we must take to reach our destination? 
Return -1 if it is not possible.

Example:
Input: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Constraints:
    1 <= routes.length <= 500.
    1 <= routes[i].length <= 10^5.
    0 <= routes[i][j] < 10 ^ 6.
*/
package com.olsh;
import java.lang.Set;
import java.lang.HashSet;
import java.lang.Map;
import java.lang.HashMap;
import java.lang.Integer;
import java.lang.Deque;
import java.lang.LinkdeList;
import java.util.Math;

class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T)return 0;
        Set<Integer>initBuses = new HashSet<>();
        Set<Integer>targetBuses = new HashSet<>();
        Map<Integer,Set<Integer>>buses = new HashMap<>();
        for (int i=0;i<routes.length;i++){
            Set<Integer>set = new HashSet<>();
            for (int j=0;j<routes[i].length;j++){
                set.add(routes[i][j]);
                if (routes[i][j]==S)initBuses.add(i);
                if (routes[i][j]==T)targetBuses.add(i);
            }
            buses.put(i, set);
        }
        
        Map<Integer,Set<Integer>> adjList = new HashMap<>();
        for (int i=0;i<routes.length;i++)
            for (int j=i+1;j<routes.length;j++){
                int sizeBefore = buses.get(i).size();
                buses.get(i).removeAll(buses.get(j));
                if (buses.get(i).size()<sizeBefore){
                    if (!adjList.containsKey(i))adjList.put(i,new HashSet<>());
                    if (!adjList.containsKey(j))adjList.put(j,new HashSet<>());
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        buses=null;
        Map<Integer,Integer>minDist = new HashMap<>();
        Deque<Integer>queue = new LinkedList<>();
        for (int initBus:initBuses){
            queue.add(initBus);
            minDist.put(initBus, 1);
        }
        while (!queue.isEmpty()){
            int vertex = queue.removeFirst();
            if (adjList.get(vertex)!=null){
            for (int child: adjList.get(vertex)){
                if (minDist.get(child)==null || minDist.get(child)>minDist.get(vertex)+1){
                    queue.add(child);
                    minDist.put(child, minDist.get(vertex)+1);
                }
            }
            }
        }
        int min = 1000000;
        for (int target:targetBuses){
            if (minDist.get(target)==null)return -1;
            else min = Math.min(minDist.get(target), min);
        } 
        return min==1000000?-1:min;
    }
}
