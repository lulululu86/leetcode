package com.luo.leetcode;
import java.util.*;
public class GraphValidTree_261 {
    /*Given n nodes labeled from 0 to n - 1 and a list of undirected edges
    (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any
two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 [0, 1] is the same as [1, 0] and thus will not appear together in edges.

*/
    public boolean validTree(int n, int[][]edges) {
        Map<Integer,Set<Integer>>graph = new HashMap<Integer, Set<Integer>>();
        boolean[]visited = new boolean[n];
        for(int[]edge:edges){
            if(!graph.containsKey(edge[0]))graph.put(edge[0],new HashSet<Integer>());
            if(!graph.containsKey(edge[1]))graph.put(edge[1],new HashSet<Integer>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean noCycle = dfs(graph,visited,0,-1);
        for(int i=0;i<n;i++){
            if(!visited[i])return false;
        }
        return noCycle;
    }
    private boolean dfs(Map<Integer,Set<Integer>>graph,boolean[]visited,int u,int pa){
       visited[u] = true;
       for(int v:graph.get(u)){
           if(!visited[v]){
               if(!dfs(graph,visited,v,u))return false;
           }else if(v!=pa)return false;
       }
       return true;
    }
    public boolean validTree1(int n,int[][]edges){
        int[]pa = new int[n];
        int[]rank = new int[n];
        Arrays.fill(rank,0);
        for(int i=0;i<n;i++)
            pa[i] = i;
        for(int[]edge:edges){
            int r1 = find(edge[0],pa);
            int r2 = find(edge[1],pa);
            if(r1==r2)return false;
            union(r1,r2,pa,rank);
        }
        return true;
    }
    public int find(int child,int[]pa){
        return child==pa[child]?child:find(pa[child],pa);
    }
    public void union(int r1,int r2,int[]pa,int[]rank){
        if(rank[r1]>rank[r2]){
            pa[r2] = r1;
        }else if(rank[r1]<r2){
            pa[r1] = r2;
        }else{
            pa[r1] = r2;
            rank[r2]++;
        }
    }
}
