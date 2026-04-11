class Solution {
    public int minCostConnectPoints(int[][] points) {
        //Prims algorithm optimized
        //earlier what we did was - we were calculating cost from every node to every neighbor and putting it in minHeap to always get the smallest cost from a node to the neighbor
        // this lead to adding nodes to minHeap n^2 times and sorting of log n time - so total Tc of n^2logn 
        // now what we can do is, while calculating the distance itself of a node to every other neighbor of it, we are directly going to store its minimum cost while caclulating it on the spot instead of puttong it in minheap for sorting

        int node=0;
        int[] distance=new int[points.length];
        boolean visited[]=new boolean[points.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int edges=0,res=0;

        while(edges<points.length-1){
            visited[node]=true;
            int nextNode=-1;
            for(int i=0;i<points.length;i++){
                if(visited[i]) continue;
                int currDistance=Math.abs(points[i][0]-points[node][0])+Math.abs(points[i][1]-points[node][1]);
                distance[i]=Math.min(distance[i],currDistance);
                if(nextNode==-1||distance[i]<distance[nextNode]){
                    nextNode=i;
                }

            }
            
                res+=distance[nextNode];
                node=nextNode;
                edges++;
        }
        return res;
    }
}
