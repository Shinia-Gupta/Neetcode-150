class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph=new HashMap<>();

        for(int i=0;i<n;i++){
          graph.computeIfAbsent(i,x->new ArrayList<>());

        }
        for(int[] flight:flights){
          int node1=flight[0],node2=flight[1],price=flight[2];
          graph.get(node1).add(new int[]{node2,price});
        } 

        int curr=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0});
        int[] minCost=new int[n];
        Arrays.fill(minCost,Integer.MAX_VALUE);

        while(!q.isEmpty() && curr<=k){
          int qSize=q.size();
          for(int i=0;i<qSize;i++){
          int[] node=q.poll();
          int currNode=node[0],currCost=node[1];
          for(int[] nei:graph.get(currNode)){
            int neiNode=nei[0],neiCost=nei[1];
            int newCost=currCost+neiCost;
            if(newCost<minCost[neiNode]){
            minCost[neiNode]=newCost;
            q.add(new int[]{neiNode,newCost});

            }
          }
          }
          curr++;
        }
        return minCost[dst]!=Integer.MAX_VALUE?minCost[dst]:-1;
    }
}
