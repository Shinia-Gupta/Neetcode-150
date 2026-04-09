class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int p[]:prerequisites){
            graph.get(p[1]).add(p[0]);  //prerequisite to course mapping
            indegree[p[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
            queue.add(i);
        }

        int finishedCourses=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            finishedCourses++;
            for(int neighbor:graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }

        return finishedCourses==numCourses;
    }
}
