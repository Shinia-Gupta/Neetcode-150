class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
          graph.computeIfAbsent(i,x->new ArrayList<>());
        }

        for(int[] p:prerequisites){
          int a=p[0],b=p[1];
          if(!graph.get(b).contains(a))
          {
            graph.get(b).add(a);
            indegree[a]++;
          }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
          if(indegree[i]==0) q.add(i);
        }

        int[] res=new int[numCourses];
        int index=0;
        int completed=0;
        while(!q.isEmpty()){
          int node=q.poll();
          res[index++]=node;
          completed++;
          for(int nei:graph.get(node)){
            indegree[nei]--;
            if(indegree[nei]==0) q.add(nei);
          }
        }
        return completed==numCourses?res:new int[0];
    }
}
