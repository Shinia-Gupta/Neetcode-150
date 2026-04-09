class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //create an adjacency list for each node containing the neighbor and it s time to reach that neighbor
        //fill in the grpah with the values of the times array
        // We need to mainitain a min heap to always extract the minimum time taken to reachthtat node out of all possible paths. So the min heap will store priority according to the minimum time required to reachthat node.
        //also the dijkstra algorithm is based on bfs, so we go level by level and for each node, we first process its neighbors instead of going on one path itself deep down and then traversing through the other possible path
        //intially the node we want to start is going to have the minimum time as 0 to reach that node itself
        //we also maintain a set to keep track of already visited nodes because if we have added it in the set before, the node has been processed with the minimum time needed to reach the other nodes via that node
        //once we have considered that node, we are going to traverse further to its neighbors

        // and finally return the time needed to send the signal to the last node via all the nodes

        Map<Integer,List<int[]>> graph=new HashMap<>();

        for(int time[]:times){
            graph.computeIfAbsent(time[0],x->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }

        PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.offer(new int[]{0,k});

        Set<Integer> visited=new HashSet<>();
        int timeToVisitAllNodes=0;

        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int weight=curr[0],node=curr[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            timeToVisitAllNodes=weight;
            if(graph.containsKey(node)){
                for(int nextNode[]:graph.get(node)){
                    int neighbor=nextNode[0],newWeight=nextNode[1];
            if(!visited.contains(neighbor)) minHeap.offer(new int[]{timeToVisitAllNodes+newWeight,neighbor});

                }
            }

        }
        return visited.size()==n?timeToVisitAllNodes:-1;
    }
}
