class Solution {
    public int swimInWater(int[][] grid) {
      //now in previous solution, we are traversing all possible paths and then arriving to a soultion to reach the bottom square in minum time
      //instead now we are going to follow dijkstra's algo to greedily go for only the path that has minimum value of all the neighbors
      //we are also going to keep travk of visited nodes to avoid traversing them again 

         boolean visited[][]=new boolean[grid.length][grid[0].length];
PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
minHeap.offer(new int[]{grid[0][0],0,0});

visited[0][0]=true;

while(!minHeap.isEmpty()){
    int[] node=minHeap.poll();
    int t=node[0],r=node[1],c=node[2];
        if(r==grid.length-1 && c==grid[0].length-1){
            return t;
        }
    for(int[] dir:directions){
        int newR=r+dir[0],newC=c+dir[1];
        if(newR<0||newC<0||newR>=grid.length||newC>=grid[0].length||visited[newR][newC]){
            continue;
        }
        minHeap.add(new int[]{Math.max(grid[newR][newC],t),newR,newC});
        visited[newR][newC]=true;
    }
}
return 0;
    }
}
