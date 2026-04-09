class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();

    for(int i=0;i<numCourses;i++){
        graph.add(new ArrayList<>());
    }

    for(int p[]:prerequisites){
        graph.get(p[0]).add(p[1]);
    }

    int[] state=new int[numCourses];
    List<Integer> resultList=new ArrayList<>();
    for(int i=0;i<numCourses;i++){
        hasCycle(graph,state,i,resultList);
    }
int[] result = new int[resultList.size()];
for(int i = 0; i < resultList.size(); i++){
    result[i] = resultList.get(i);
}
    return resultList.size()==numCourses?result:new int[]{};
    }

    private boolean hasCycle(List<List<Integer>> graph,int[] state,int i,List<Integer> resultList){
        if(state[i]==1) return true;    //has cycle
        if(state[i]==2) return false;   //is safe

        state[i]=1;

        for(int dependee:graph.get(i)){
            if(hasCycle(graph,state,dependee,resultList)){
                return true;
            }
        }
        state[i]=2;
        resultList.add(i);
        return false;
    }
}
