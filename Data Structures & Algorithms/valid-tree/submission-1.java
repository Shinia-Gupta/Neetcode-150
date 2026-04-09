class Solution {
    public boolean validTree(int n, int[][] edges) {
           if(edges.length!=n-1) return false;

            List<List<Integer>> graph=new ArrayList<>();
            int[] state=new int[n];

            for(int i=0;i<n;i++){
                graph.add(new ArrayList<>());
            }

            for(int edge[]:edges){
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            for(int i=0;i<n;i++){
                if(state[i]==0 && hasCycle(i,-1,graph,state)){
                    return false;
                }
            }

            return true;

    }

    private boolean hasCycle(int node,int parent,List<List<Integer>> graph,int[] state){
            state[node]=1;

        for(int neighbor:graph.get(node)){
            if(neighbor==parent) continue;
            if(state[neighbor]==1) return true;


            if(hasCycle(neighbor,node,graph,state)){
                return true;
            }
        }
        return false;
    }
}
