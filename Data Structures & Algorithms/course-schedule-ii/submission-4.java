class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        Map<Integer,Integer> indegreeMap=new HashMap<>();
        List<Integer> resultList=new ArrayList<>();
        int[] result=new int[numCourses];
        //initialize maps
        for(int i=0;i<numCourses;i++){
          graph.computeIfAbsent(i,x->new ArrayList<>());
          indegreeMap.put(i,0);
        }

        //create directed edges and calculate indegrees for each node
        for(int prereq[]:prerequisites){
          int a=prereq[0],b=prereq[1];
          graph.get(b).add(a);
          indegreeMap.put(a,indegreeMap.get(a)+1);
        }

        //initialize queue
        Queue<Integer> q=new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:indegreeMap.entrySet()){
          if(entry.getValue()==0) q.add(entry.getKey());
        }

        //process nodes
        while(!q.isEmpty()){
          int node=q.poll();
          resultList.add(node);
          for(int neighbor:graph.get(node)){
          indegreeMap.put(neighbor,indegreeMap.get(neighbor)-1);
          if(indegreeMap.get(neighbor)==0) q.add(neighbor);
          }
        }
        int index=0;
        for(int node:resultList){
            result[index++]=node;
        }
        return resultList.size()==indegreeMap.size()?result:new int[0];


    }
}
