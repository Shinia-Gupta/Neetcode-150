class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
      // what i am thinking is, we are going to perform a bfs here
      // for the node JFK, we are going to traverse its neighbor and for multiple neighbors possible, we are already going to take into account, the path that gives the smallest lexical order.
      // so instead of finding all paths and then finding shortest lexical order all over traversing through all the paths,
    //   we are already going to take into account the neighbor from that particular node that gives the smallest possible lexical order of all the neighbors first

    //create an adjacency list of all the nodes possible
    // Map<String,List<String>> graph=new HashMap<>(Comparator.comparingString(a->a[0]));  // add neighbors for a node lexicographically to always go with the neighbor having smallest lexicographic path
    // for(String ticket[]:tickets){
    //     graph.computeIfAbsent(ticket[0],x->new ArrayList<>()).add(ticket[1]);
    // }
      //FIX - USE PRIORITY QUEUE
   Map<String,PriorityQueue<String>> graph=new HashMap<>();  // add neighbors for a node lexicographically to always go with the neighbor having smallest lexicographic path
    for(List<String> ticket:tickets){
        graph.computeIfAbsent(ticket.get(0),x->new PriorityQueue<>()).offer(ticket.get(1));
    }

    List<String> result=new LinkedList<>();
            dfs("JFK",result,graph);
            result.addFirst("JFK");

            return result;
    }

    private void dfs(String node,List<String> result,Map<String,PriorityQueue<String>> graph) {
        PriorityQueue<String> neighbors=graph.get(node);
        
        while(neighbors!=null && !neighbors.isEmpty()){

        // for(String neighbor:neighbors){
        String neighbor=neighbors.poll();
         dfs(neighbor,result,graph);
         result.addFirst(neighbor);
        }

     }
    }

