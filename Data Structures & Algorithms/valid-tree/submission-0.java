class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false; //check if there is full connectivity between nodes

        int[] state=new int[n];
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }

        for(int i=0;i<n;i++){
            if(state[i]==0 && hasCycle(i,edges,state,graph,-1)){
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node,int[][] edges,int[] state,List<List<Integer>> graph,int parent)
    {

        state[node]=1;      //currently visiting the node in current dfs cycle

        for(int neighbor:graph.get(node)){
            if(neighbor==parent) continue;
            if(state[neighbor]==1) return true; //cycle exists

            if(hasCycle(neighbor,edges,state,graph,node)){
                return true;
            }
        }
        return false;
    }
}
