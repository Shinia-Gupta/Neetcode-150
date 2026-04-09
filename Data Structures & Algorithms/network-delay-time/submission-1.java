// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         //create an adjacency list keeping track of all neighbors for each node
//         //to store the result, we are going to pass an array so that the value remains intact during dfs traversal recursions.
//         //we also need a visited array to keep track of the node already have been visited
//         //we start the traversal from node k
//         // extract the neighbors of k. For each neighbor, we count the total time so far and pass that total time in the recursion. base case- if the neighbor of a node is empty, we have traversed all nodes and hence we return the total time percieved so far. Also, we need to check if all nodes were visited or not. So we can keep a count of total nodes intially and match the node count encountered so far with it. If it is equal, we traversed the entire nodes and can set it as our current answer
//         //and proceed to next neighbor of k
//         if(n==1) return 0;
//         Map<Integer,List<int[]>> graph=new HashMap<>();
//         // for(int i=0;i<=n;i++){
//         //     graph.add(new HashMap<>());
//         // }

//         for(int time[]:times){
//             //for each node, node is the key and list of neighbors and its time for each neighbor is the value
//     //    List<int[]> neighbors=graph.getOrDefault(time[0],new ArrayList<>());
//             // map.put(time[0],map.getOrDefault(time[1],new ArrayList<>()));
//             // graph.put(time[0],neighbors.add(new int[]{time[1],time[2]}));  //i need to correct this, i need to add an arraylist of integer arrays intead  
//        //FIX
//        graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
//         }

//         int ans=Integer.MAX_VALUE;
//         for(int[] neighbor:graph.getOrDefault(k,new ArrayList<>())){
//         boolean[] visited=new boolean[n+1];
//             int[] visitedNodes=new int[1];
//             visited[k]=true;
//             visitedNodes[0]++;   //considering already considered node before the first dfs traversal
//             int time=dfs(graph,visited,neighbor,visitedNodes,n,neighbor[1]);
//             // if(visitedNodes[0]==n)
//             if(time!=Integer.MAX_VALUE)
//             ans=Math.min(ans,time);
        
//         }

// return ans==Integer.MAX_VALUE?-1:ans;
//     }

//     private int dfs(Map<Integer,List<int[]>> graph,boolean[] visited,int[] node,int[] visitedNodes,int totalNodes,int currentTime){
//        if(visited[node[0]]) return Integer.MAX_VALUE;
//         visited[node[0]]=true;
//         visitedNodes[0]++;
//         if(visitedNodes[0]==totalNodes){
//              visited[node[0]] = false;
//             visitedNodes[0]--;
//            return currentTime;
//         }

//         // return dfs(graph,visited,graph.get(node[0]),visitedNodes,totalNodes,currentTime+node[1]);
//    //FIX
//    int minTime=Integer.MAX_VALUE;
//     for(int[] next : graph.getOrDefault(node[0], new ArrayList<>())){
//             if(!visited[next[0]]){
//                 minTime = Math.min(minTime,
//                     dfs(graph, visited, next, visitedNodes, totalNodes, currentTime + next[1])
//                 );
//             }
//         }
//         visited[node[0]] = false;
//             visitedNodes[0]--;

//         return minTime;
//     }
// }
public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0],
            x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) dist.put(i, Integer.MAX_VALUE);

        dfs(k, 0, adj, dist);
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int node, int time,
                     Map<Integer, List<int[]>> adj,
                     Map<Integer, Integer> dist) {
        if (time >= dist.get(node)) return;
        dist.put(node, time);
        if (!adj.containsKey(node)) return;
        for (int[] edge : adj.get(node)) {
            dfs(edge[0], time + edge[1], adj, dist);
        }
    }
}