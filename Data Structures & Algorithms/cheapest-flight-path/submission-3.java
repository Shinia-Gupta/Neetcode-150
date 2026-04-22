class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      //currently what i think is, hume ek graph bnana h har node se uske neighbors tak with the cost it takes to visit that neighbor from the current node
      //fir hum unn multiple neighbors mei se ek neighbor choose krenge jiski cost to reach that neighbor will be cheapest
      //though it is one point that it is not mandatory that chossing the neighbor with the cheapest price first will lead us to destination with number of stops condition satisfied
      //but if while considering one direction with cheapest path, we encounter the condition being violated at some point, we trace back to other neighbor from the current path going on the path
      //if the node that we are currently considering along the path becomes equal to destination, we return the cost encountered so far
      //but again, it is also possible that there maybe multiple valid paths possible to reach the desination where the number of stops condition is also satisfied
      //how are we then going to check which is the cheapest path...

      Map<Integer,List<int[]>> graph=new HashMap<>();
      int[] minCost=new int[n];
      Arrays.fill(minCost,Integer.MAX_VALUE);

      for(int i=0;i<n;i++){
        graph.computeIfAbsent(i,x->new ArrayList<>());
      }

      for(int[] flight:flights){
        int source=flight[0],dest=flight[1],price=flight[2];
          graph.get(source).add(new int[]{dest,price});
      }

      Queue<int[]> q=new LinkedList<>();
      q.add(new int[]{src,0});

      int stops=0;
      while(!q.isEmpty() && stops<=k){
        int qsize=q.size();
        for(int i=0;i<qsize;i++){
          int qnode[]=q.poll();
          int nodeCost=qnode[1];
          for(int[] nei:graph.get(qnode[0])){
            int neiNode=nei[0],neiCost=nei[1];
            int newCost=neiCost+nodeCost;
            if(newCost<=minCost[neiNode]){
            minCost[neiNode]=Math.min(minCost[neiNode],newCost);
            q.add(new int[]{neiNode,newCost});
            }
          }
        }
        stops++;
      }

      return minCost[dst]==Integer.MAX_VALUE?-1:minCost[dst];
    }
}
