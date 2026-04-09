class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        //add prerequisite->course mapping
        for(int p[]:prerequisites){
            graph.get(p[1]).add(p[0]);  //add prerequisite to course mapping
            indegree[p[0]]++;   //add number of dependees for the node
        }

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
            queue.add(i);
        }

        int finishedCourses=0;
        int[] result=new int[numCourses];
        int index=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            finishedCourses++;
            result[index++]=node;
            for(int neighbor:graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }
        return finishedCourses==numCourses?result:new int[0];

    }
}
