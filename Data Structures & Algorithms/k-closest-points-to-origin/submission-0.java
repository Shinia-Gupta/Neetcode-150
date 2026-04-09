class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
int[][] res=new int[k][2];
// PriorityQueue<int[]> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<int[]> maxHeap =
    new PriorityQueue<>(
        (a, b) -> {
            int da = a[0]*a[0] + a[1]*a[1];
            int db = b[0]*b[0] + b[1]*b[1];
            return db - da; // reverse for max heap
        }
    );

for(int i=0;i<points.length;i++){
    // for(int j=0;j<points[0].length;j++){
    // }
        int[] currPoint=points[i];
        // int d1=(0-currPoint[0])*(0-currPoint[0]);
        // int d2=(0-currPoint[1])*(0-currPoint[1]);
        // int euclideanDistance=(int)Math.sqrt(d1+d2);
maxHeap.offer(currPoint);
if(maxHeap.size()>k){
    maxHeap.poll();
}
}
// while(!maxHeap.isEmpty()){
    for(int i=0;i<k;i++){
        res[i]=maxHeap.poll();
    }
// }
return res;
    }
}
