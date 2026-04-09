class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph=new HashMap<>();

        for(int[] time:times){
            graph.computeIfAbsent(time[0],x->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }

        Map<Integer,Integer> distance=new HashMap<>();
        for(int i=1;i<=n;i++) distance .put(i,Integer.MAX_VALUE);

        dfs(k,0,distance,graph);
        int res=Collections.max(distance.values());  //when is Collections.max used, in what data structures can it be used, and what does values() give, how is it different from getValues() of Map.Entries
        return res==Integer.MAX_VALUE?-1:res;  //if res is Integer.MAX_VALUE, it means one of the node wasnt visited by that start node i.e k and hence we cant visite all the nodes from that node

    }

    private void dfs(int node,int time,Map<Integer,Integer> distance,Map<Integer, List<int[]>> graph){
        if(time>=distance.get(node)) return;    //why cant time be more than the distance of current node? what if all nodes havent been visited. Wont it not allow that node to be visited?
        distance.put(node,time);

        for(int[] neighbor:graph.getOrDefault(node,new ArrayList<>())){
        dfs(neighbor[0],time+neighbor[1],distance,graph);
        }
    }
}
