class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph=new HashMap<>();
        
        for(int i=1;i<=n;i++){
            graph.computeIfAbsent(i,x->new ArrayList<>());
        }

        for(int time[]:times){
            int node1=time[0],node2=time[1],t=time[2];
            graph.get(node1).add(new int[]{node2,t});
        }

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[]{k,0});
        // HashSet<Integer> visited=new HashSet<>();
        int[] minTime=new int[n+1];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        minTime[k]=0;
        int totalTime=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int qNode[]=q.poll();
            int currNode=qNode[0],currCost=qNode[1];
            if(currCost> minTime[currNode]) continue;
            for(int nei[]:graph.get(currNode)){
                int newCost=currCost+nei[1];
                if(minTime[nei[0]]>newCost){        //if the minTime is not integer's max value, we will consider it as a visited node also - this statement is wrong, dijkstra can push same node multiple times because a path at a later stage may contain that node with a smaller cost or time
                minTime[nei[0]]=Math.min(minTime[nei[0]],newCost);
                q.add(new int[]{nei[0],newCost});
                }

            }

        }

        for(int i=1;i<minTime.length;i++){
            if(minTime[i]==Integer.MAX_VALUE) return -1;
                totalTime=Math.max(totalTime,minTime[i]);
        }
            return totalTime;
    }
}
