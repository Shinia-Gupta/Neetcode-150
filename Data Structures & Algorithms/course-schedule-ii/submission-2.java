class Solution {
    //BFS- Kahn Alhorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        // Map<Integer,Set<Integer>> nodeToPrereqMap=new HashMap<>();
        int[] indegree=new int[numCourses];

    for(int i=0;i<numCourses;i++){
        graph.add(new ArrayList<>());
    }

    for(int p[]:prerequisites){
        graph.get(p[0]).add(p[1]);
        // if(!nodeToPrereqMap.containsKey(p[0])){
        //     Set<Integer> prereq=new HashSet<>();
        //     prereq.add(p[1]);
        //     nodeToPrereqMap.put(p[0],prereq);
        // }else{
        //     Set<Integer> prereq=nodeToPrereqMap.get(p[0]);
        //     prereq.add(p[1]);
        //     nodeToPrereqMap.put(p[0],prereq);            
        // }
        indegree[p[1]]++;   //why incrementing indegree of a prerequisuite instead of the node??
    }

for(int i=0;i<numCourses;i++){
    if(indegree[i]==0){
        queue.add(i);
    }
}

    // List<Integer> resultList=new ArrayList<>();
    // kahnAlgorithmBFS(graph,resultList,queue,nodeToPrereqMap);
int[] result = new int[numCourses];
// for(int i = 0; i < resultList.size(); i++){
//     result[i] = resultList.get(i);
// }
int finish=0;
while(!queue.isEmpty()){
    int node=queue.poll();
    result[numCourses-finish-1]=node;
    finish++;
    for(int neighbor:graph.get(node)){
        indegree[neighbor]--;   //one prerequisite of that neighbor has been processed, so it is available
        if(indegree[neighbor]==0){
            queue.add(neighbor);
        }

    }
}

if(finish!=numCourses){
    return new int[0];
}

    return result;
    }

//     private void kahnAlgorithmBFS(List<List<Integer>> graph,List<Integer> resultList,Queue<Integer> queue,Map<Integer,List<Integer>> map){
//         while(!queue.isEmpty()){
//             int node=queue.poll();
//             List<Integer> prereq=graph.get(node);
//             Set<Integer> dependencies=map.get(node);
//             for(int p:prereq){
//                 if(!dependencies.contains(p)){
//                     resultList.add(p);
//                     if(!queue.contains(p))
//                     queue.add(p);

//                 }else{
//                     dependencies.remove(p);
//                     map.put(node,dependencies);

//                 }
//             }
//             resultList.add(node);
//             queue.add()

//         }
//     }
}
