class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        // Map<Integer,Integer> indegreeMap=new HashMap<>();
        int[] indegreeMap=new int[numCourses];
        // List<Integer> resultList=new ArrayList<>();
        int[] result=new int[numCourses];
        //initialize maps
        for(int i=0;i<numCourses;i++){
          graph.computeIfAbsent(i,x->new ArrayList<>());
          // indegreeMap.put(i,0);
        }
        // Arrays.fill(indegreeMap,0);

        //create directed edges and calculate indegrees for each node
        for(int prereq[]:prerequisites){
          int a=prereq[0],b=prereq[1];
          graph.get(b).add(a);
          // indegreeMap.put(a,indegreeMap.get(a)+1);
          indegreeMap[a]++;
        }

        //initialize queue
        Queue<Integer> q=new LinkedList<>();
        // for(Map.Entry<Integer,Integer> entry:indegreeMap.entrySet()){
        //   if(entry.getValue()==0) q.add(entry.getKey());
        // }
        for(int i=0;i<indegreeMap.length;i++){
          if(indegreeMap[i]==0) q.add(i);
        }

        //process nodes
        int index=0;
        while(!q.isEmpty()){
          int node=q.poll();
          // resultList.add(node);
          result[index++]=node;
          for(int neighbor:graph.get(node)){
          // indegreeMap.put(neighbor,indegreeMap.get(neighbor)-1);
          indegreeMap[neighbor]--;
          // if(indegreeMap.get(neighbor)==0) q.add(neighbor);
          if(indegreeMap[neighbor]==0) q.add(neighbor);
          }
        }
        // int index=0;
        // for(int node:resultList){
        //     result[index++]=node;
        // }
        return index==numCourses?result:new int[0];


    }
}
