// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         Map<Integer, List<int[]>> graph=new HashMap<>();

//         for(int i=1;i<=n;i++){
//           graph.computeIfAbsent(i,x->new ArrayList<>());
//         }

//         for(int[] time:times){
//           int src=time[0],dest=time[1],t=time[2];
//           graph.get(src).add(new int[]{dest,t});
//         }

//         PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]);
//         q.add(new int[]{k,0});
//         int[] minTime=new int[n+1];
//         Arrays.fill(minTime,Integer.MAX_VALUE);
//         // int numNodes=0;
//         int maxTime=Integer.MIN_VALUE;
//         while(!q.isEmpty()){
//           int qSize=q.size();

//           for(int i=0;i<qSize;i++){
//             int node[]= q.poll();
//             // numNodes++;
//             int currNode=node[0],currTime=node[1];
//             if(currTime>minTime[currNode]) continue;
//             for(int[] nei:graph.get(currNode)){
//               int neiNode=nei[0],neiTime=nei[1];
//               int newTime=currTime+neiTime;
//               if(newTime<minTime[neiNode]){
//                 minTime[neiNode]=newTime;
//                 maxTime=Math.max(minTime[neiNode],maxTime);
//                 q.add(new int[]{neiNode,newTime});
//               }
//             }
//           }
//         }
//         return maxTime;
//     }
// }

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] time: times){
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        minTime[k] = 0;
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];

            if(time > minTime[node]) continue;

            for(int[] nei: graph.get(node)){
                int newTime = time + nei[1];
                if(newTime < minTime[nei[0]]){
                    minTime[nei[0]] = newTime;
                    pq.add(new int[]{nei[0], newTime});
                }
            }
        }

        int maxTime = 0;
        for(int i=1;i<=n;i++){
            if(minTime[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, minTime[i]);
        }

        return maxTime;
    }
}
