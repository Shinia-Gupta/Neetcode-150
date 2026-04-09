class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int[] taskCount=new int[26];
        int time=0; 
        // frequency of each task 
        for(int i=0;i<tasks.length;i++){
    taskCount[tasks[i]-'A']++;
}
for(int taskFreq:taskCount){
    if(taskFreq>0)
    maxHeap.offer(taskFreq);
}
Queue<int[]> nextAvailTaskTimeQueue=new LinkedList<>();
while(!maxHeap.isEmpty()|| !nextAvailTaskTimeQueue.isEmpty()){
    time++;

if(maxHeap.isEmpty())
time=nextAvailTaskTimeQueue.peek()[1];
else{
int priorityTask=maxHeap.poll();
int currentFreqAfterRunning=priorityTask-1;
if(currentFreqAfterRunning>0)
nextAvailTaskTimeQueue.add(new int[]{currentFreqAfterRunning,time+n});
}
if(!nextAvailTaskTimeQueue.isEmpty() && time==nextAvailTaskTimeQueue.peek()[1]){
    maxHeap.offer(nextAvailTaskTimeQueue.poll()[0]);
}
}
   return time;     
    }
}
