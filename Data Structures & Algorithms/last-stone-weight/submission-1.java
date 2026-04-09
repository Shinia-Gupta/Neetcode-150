class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            maxHeap.offer(stones[i]);
        }
        while(!maxHeap.isEmpty() && maxHeap.size()>1){
            int stone1=maxHeap.poll();
            int stone2=maxHeap.poll();

            if(stone1>stone2||stone1<stone2){
                maxHeap.offer(Math.abs(stone1-stone2));
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}
