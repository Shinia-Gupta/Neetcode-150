class MedianFinder {
PriorityQueue<Integer> minHeap;
PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if((minHeap.isEmpty() && maxHeap.isEmpty())|| num>minHeap.peek()) minHeap.offer(num);
        else{
                maxHeap.offer(num);
            
        }
        if(Math.abs(minHeap.size()-maxHeap.size())>1){
            while(minHeap.size()>maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
            while(maxHeap.size()>minHeap.size()){
                minHeap.offer(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        //odd number of elements? - median in larger heap
        if((minHeap.size()+maxHeap.size())%2!=0){
            return (double) (minHeap.size()>maxHeap.size()?minHeap.peek():maxHeap.peek());
        }else{
            return (double)((minHeap.peek()+maxHeap.peek())/2.0);
        }
    }
}
