class Solution {
    public int minCostConnectPoints(int[][] points) {
       //Prim's algorithm
       //For every node in graph, each node can connect to every other node
       // so we need to store each neighbor of each node in adjacency list and its manhatten distance
       //we also need to create  a minheap based on the smallest distance for a node
       //means- for a node i, which neighbor is the closest
       //now there are multiple ways to reach a node j from every node i, but we need to find which node i has the smallest dustance to reach node j.
       //so we need to keep adding neighbors of every node into the heap to always get the smallest distance to reach a node j.
       //also, we need to keep track of visited nodes. If the node has been already visited, it is having the smallest distance to reach it(the node)
       //so we dont need to recalculate/reconsidder a visited node again
       // once the size of visited nodes= the total number of nodes, we can return the result

       Set<Integer> visited=new HashSet<>();
       Map<Integer,List<int[]>> graph=new HashMap<>();
       for(int i=0;i<points.length;i++){
        for(int j=i+1;j<points.length;j++){
        int[] point1=points[i];
        int[] point2=points[j];
        int cost=Math.abs(point1[0]-point2[0])+Math.abs(point1[1]-point2[1]);
        graph.computeIfAbsent(i,x->new ArrayList<>()).add(new int[]{cost,j});
        graph.computeIfAbsent(j,x->new ArrayList<>()).add(new int[]{cost,i});

        }

       }

       int totalDistance=0;
        PriorityQueue<int[]>minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.add(new int[]{0,0});
        while(visited.size()!=points.length){
           int[] point= minHeap.poll();
           if(visited.contains(point[1])){
            continue;
           }

           totalDistance+=point[0];
           visited.add(point[1]);
           for(int[] neighbor:graph.getOrDefault(point[1],new ArrayList<>())){
            if(!visited.contains(neighbor[1])){
                minHeap.add(new int[]{neighbor[0],neighbor[1]});
            }
           }
        }
        return totalDistance;
    }
}
