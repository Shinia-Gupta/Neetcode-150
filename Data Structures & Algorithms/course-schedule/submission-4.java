class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        Map<Integer,Integer> nodeToPrereqMap=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();

        int count=0;
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int prereq[]:prerequisites){
            graph.get(prereq[1]).add(prereq[0]);
            if(!nodeToPrereqMap.containsKey(prereq[0]))nodeToPrereqMap.put(prereq[0],1);
            else{
                nodeToPrereqMap.put(prereq[0],nodeToPrereqMap.get(prereq[0])+1);
            }
        }

        for(int i=0;i<numCourses;i++){
            if(!nodeToPrereqMap.containsKey(i)){
                queue.add(i);
            }
        }
        return hasCycleBfs(graph,nodeToPrereqMap,queue,numCourses);
             



        
    }

    private boolean hasCycleBfs(List<List<Integer>> graph,Map<Integer,Integer> map,Queue<Integer> queue,int numCourses)
    {
        int count=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            count++;
            for(int neighbor:graph.get(node)){
                if(map.containsKey(neighbor)){
                    map.put(neighbor,map.get(neighbor)-1);
                    if(map.get(neighbor)==0){
                        queue.add(neighbor);
                        map.remove(neighbor);
                    }
                }
            }
        }
        return count==numCourses;
    }
}
