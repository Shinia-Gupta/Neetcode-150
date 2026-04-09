class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] p:prerequisites){
            //add each dependent's dependee in the graph
            graph.get(p[1]).add(p[0]);
        }

        int[] state=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(hasCycle(graph,state,i)){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph,int[] state,int node){
            if(state[node]==1) return true;    //found the node to be revisiting in the same dfs cycle
            if(state[node]==2) return false;     //already safe

            state[node]=1;

            for(int neighbor:graph.get(node)){
                if(hasCycle(graph,state,neighbor)){
                    return true;
                }
            }
            state[node]=2;
            return false;
    }
}
