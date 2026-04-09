class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();

        //build an empty graph
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        //add dependents for each node
        for(int[] p:prerequisites){
            graph.get(p[1]).add(p[0]);
        }

        int[] state=new int[numCourses];
        //start with all nodes
        for(int i=0;i<numCourses;i++){
                if(dfs(graph,state,i)){
                    return false;   //cycle detected
                }
            
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph,int[] state,int node){
        if(state[node]==1) return true;    //cycle detected as the node has been already visited inthe current DFS call
        if(state[node]==2) return false;    //safe

        state[node]=1;  //currently visiting

        for(int neighbor:graph.get(node)){
            if(dfs(graph,state,neighbor)){
                return true;
            }
        }

        state[node]=2;
        return false;

    }
}
