class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        Map<Integer,Integer> indegreeMap=new HashMap<>();

        //initalize maps
        for(int i=0;i<numCourses;i++){
            graph.computeIfAbsent(i,x->new ArrayList<>());
            indegreeMap.put(i,0);
        }

        //directed edges
        for(int[] prereq:prerequisites){
            int a=prereq[0],b=prereq[1];
            // if(!graph.get(a).contains(b)){
                graph.get(b).add(a);
                indegreeMap.put(a,indegreeMap.get(a)+1);
            // }
        }

        //queue intialization
        Queue<Integer> q=new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:indegreeMap.entrySet()){
            if(entry.getValue()==0) q.add(entry.getKey());
        }
        int finished=0;
        while(!q.isEmpty()){
            int node=q.poll();
            finished++;
            for(int neighbor:graph.get(node)){
                indegreeMap.put(neighbor,indegreeMap.get(neighbor)-1);
                if(indegreeMap.get(neighbor)==0) q.add(neighbor);
            }
        }

        return finished==numCourses?true:false;
    }
}
