class Solution {
    public int countComponents(int n, int[][] edges) {
        //create an adjacency list for all the nodes 
        //create a visited matrix to keep track of nodes that have been visited
        //also keep track of the parent node from which you are opening the traversal
        //while starting the traversal from the node,heck if that node is not already visited so that we can keep track of number of connected components
        //if the neighboring node while traversing a node is a parent, dont count it and go further for other beighboring nodes

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] visited=new int[n];
        int numConnected=0;
        for(int i=0;i<n;i++){
            if(visited[i]!=1 ){
                connectedNodes(graph,visited,i,-1);
                numConnected++;
            }
        }

        return numConnected;
    }

    private void connectedNodes(List<List<Integer>> graph,int[] visited,int node,int parent){

visited[node]=1;


for(int neighbor:graph.get(node)){
    if(neighbor==parent) continue;
    if(visited[neighbor]==1) continue;
    connectedNodes(graph,visited,neighbor,node);
}
    }
}
