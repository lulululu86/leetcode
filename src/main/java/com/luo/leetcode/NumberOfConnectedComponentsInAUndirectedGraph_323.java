package com.luo.leetcode;
import java.util.*;
public class NumberOfConnectedComponentsInAUndirectedGraph_323 {
    /*Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     write a function to find the number of connected components in an undirected graph.

Example 1:

     0          3

     |          |

     1 --- 2    4

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

     0           4

     |           |

     1 --- 2 --- 3

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:

You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
[0, 1] is the same as [1, 0] and thus will not appear together in edges.*/
    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++)graph[i] = new ArrayList<Integer>();
        for(int[]edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[]visited = new boolean[n];
        int res = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,visited,i);
                res++;
            }
        }
        return res;
    }
    private void dfs(ArrayList<Integer>[]graph,boolean[]visited,int cur){
        visited[cur] = true;
        for(int adj:graph[cur]){
            if(!visited[adj])
                dfs(graph,visited,adj);
        }
    }

    public int countComponents1(int n, int[][] edges) {
        int[]pa = new int[n];
        int[]de = new int[n];
        for(int i=0;i<n;i++)pa[i] = i;
        int res = n;
        for(int[]edge:edges){
            int r1 = find(edge[0],pa);
            int r2 = find(edge[1],pa);
            if(r1!=r2) {
                union(r1, r2, pa,de);
                res--;
            }
        }
        return res;
    }
    private int find(int v,int[]pa){
        return v==pa[v]?v:(pa[v]=find(pa[v],pa));
    }
    private void union(int r1,int r2,int[]pa,int[]de){
        if(de[r1]==de[r2]){
            pa[r1] = r2;
            de[r2]++;
        }else if(de[r1]<de[r2]){
            pa[r1] = r2;
        }else pa[r2] = r1;
    }
}
