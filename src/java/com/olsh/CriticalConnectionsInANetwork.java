/*
1192. Critical Connections in a Network
Hard
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections 
forming a network where connections[i] = [a, b] represents a connection between servers a and b. 
Any server can reach any other server directly or indirectly through the network
A critical connection is a connection that, if removed, will make some server unable to reach some other server.
Return all critical connections in the network in any order
Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
*/

package com.olsh;
import java.lang.List;
import java.lang.Integer;
import java.lang.Map;
import java.lang.Set;
import java.lang.HashMap;
import java.lang.HashSet;
import java.lang.ArrayList;
import java.util.Math;

class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[]indices=new int[n];
        int[]leastValues = new int[n];
        for (int i=0;i<leastValues.length;i++)leastValues[i]=n;
        Map<Integer, Set<Integer>>adjList = new HashMap<>();
        for (List<Integer>c:connections){
            if (!adjList.containsKey(c.get(0)))
                adjList.put(c.get(0),new HashSet<>());
            if (!adjList.containsKey(c.get(1)))
                adjList.put(c.get(1),new HashSet<>());
            adjList.get(c.get(0)).add(c.get(1));
            adjList.get(c.get(1)).add(c.get(0));
        }
        Map<Integer, Set<Integer>>dfs = new HashMap<>();
        dfs(indices, adjList, new HashSet<>(),dfs,0);
        List<List<Integer>>res = new ArrayList<>();
        for (int v: indices) findLeastAccessible(v, leastValues, indices, dfs, n, res);
       
        return res;
    }
    
    public void dfs(int[]indices, Map<Integer, Set<Integer>>adjList, Set<Integer>visited, Map<Integer, Set<Integer>>dfs, int vertex){
            indices[vertex]=visited.size();
            visited.add(vertex);
            if (adjList.get(vertex)!=null){
                dfs.put(vertex, new HashSet<>());
                for (int child: adjList.get(vertex)) {
                    if (dfs.get(child)==null || !dfs.get(child).contains(vertex))
                        dfs.get(vertex).add(child);
                    if (!visited.contains(child)){
                        dfs(indices, adjList, visited, dfs, child);
                    }
                }
            }
        }
    
    public void findLeastAccessible(int v, int[]leastValues, int[]indices, Map<Integer, Set<Integer>>dfs, int n, List<List<Integer>>res){
        if (leastValues[v]==n){
           leastValues[v]=Math.min(leastValues[v], indices[v]);
            for (int child:dfs.get(v)){
                findLeastAccessible(child, leastValues, indices, dfs, n, res);
                leastValues[v]=Math.min(leastValues[v], leastValues[child]);
                if (indices[v]<leastValues[child]){
                    List<Integer>r = new ArrayList<>();
                    r.add(v);
                    r.add(child);
                    res.add(r);
                }
            }
        }
    }
}
