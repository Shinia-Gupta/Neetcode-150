class Solution {
        Map<String,PriorityQueue<String>> graph=new HashMap<>();
        List<String> result=new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket:tickets){
          graph.computeIfAbsent(ticket.get(0),x->new PriorityQueue<>()).offer(ticket.get(1));
        }

        dfs("JFK");
        return result;
    }

    private void dfs(String node){
      PriorityQueue<String> neighbors=graph.get(node);

      while(neighbors!=null && !neighbors.isEmpty()){
       String neighbor=neighbors.poll();
       dfs(neighbor);
      }
       result.addFirst(node);
    }
}
