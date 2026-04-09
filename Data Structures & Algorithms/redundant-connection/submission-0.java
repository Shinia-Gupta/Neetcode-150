class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //agar n nodes hai,aur n-1 edges exist krne chahiye the, toh number of cycles in a graph if existing, will always be 1
        //toh hume ye check krna h ki kis parent node se cycle detection true aa rhi h
        //jis parent node se cycle detection true aa gyi, uss parent node ke last neighbor ke saath jo edge h, vo edge hume return krdena h
        //hume ismei bfs lagani chahiye kyunki ek node pe traverse krne k baad ye aage uske beighbors e nikal jayega cycle detection traverse krne k liye aur jis node pe supose agar 1 pe already cycle detect ho rha hoga toh vo 1 ke neighbors mei cycle detection check krke aane k baad 1 pe check krega ki cycle exist krta h ya nhi, but this is according to the example 2 given that i am thinking like this, it can differ from graph to graph not just for this graph that i specifically need to apply bfs or dfs into it
        //during dfs we need to maintain a parent as well because it is an undirected graph and not a directed graph to be able to just check visited and end up in an infinite loop otherwise unnecessarily
        int n=edges.length;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){  //since numbering is from 1 to n and not 0 to n-1,so avoiding index out of bound exception while creating arraylists
            graph.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<int[]> resEdges=new ArrayList<>();

        for(int i=1;i<=n;i++){
                // if(visited[i]!=1){ we cant check whether the current node is visited r not because it will remove the possibilities of having other edges as being part of the cycle if multiple valid answers exist.
                //so we need to send a new visited array everytime for each new node
        int[] visited=new int[n+1];
                   cycleFound(graph,visited,i,-1,resEdges);
                    // resEdges.add(res);
                }
        

        if(resEdges.size()==1){
            return resEdges.get(0);
        }
        for(int i=edges.length-1;i>=0;i--){
        for(int[] edge:resEdges){
            if(edge[0]==edges[i][0] && edge[1]==edges[i][1] || edge[0]==edges[i][1] && edge[1]==edges[i][0] ){
                return edges[i];
            }
        } 
        }
return new int[0];

    }

    private void cycleFound(List<List<Integer>> graph,int[] visited,int node,int parent,List<int[]> resEdges){
        visited[node]=1;

        for(int neighbor:graph.get(node)){
            if(neighbor==parent) continue;
            if(visited[neighbor]==1) {
                resEdges.add(new int[]{neighbor,node});
                return;
            }
            cycleFound(graph,visited,neighbor,node,resEdges);
        }
    }
}
