// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//       /*
//       being at a point, how are we going to check whether some other point is accessible from that point or not
// suppose taking the example [3,3], we can go to 2,4 and 4,2 both. so for ex-

// Input: points = [[0,0],[2,2],[3,3],[2,4],[4,2]]

// Output: 10

// if we see in general, if we start taking out the manhatten distance between the 2 consecutive points of the array, it will be 4,2,2,4 which sums up to 12. but in reality, considering point [3,3], we are supposed to return the Manhattan distance from [3,3] to 2,4 and 4,2 instead of going from 3,3 to 2,4 and from 2,4 to 4,2 to get the minimum cost.

// should I sort the points in ascending order? - nlogn


// 0,0
// 2,2
// 2,4
// 3,3
// 4,2

// then it will be 4,2,2,2
      
      
//       */
//       int newPoints[][]=new int[points.length][points[0].length];
      
//       for(int i=0;i<points.length;i++){
//         for(int j=0;j<points[0].length;j++){
//           newPoints[i][j]=points[i][j];
//         }
//       }

//       Arrays.sort(newPoints,(a,b)->a[0]-b[0]);
//       int distance=0;
//       for(int i=0;i<newPoints.length-1;i++){
//         int[] points1=newPoints[i];
//         int[] points2=newPoints[i+1];

//         int newDistance=Math.abs(points1[0]-points2[0])+Math.abs(points1[1]-points2[1]);
//         distance+=newDistance;
//       }

// return distance;
//     }

//     /*
//     This approach failed for some test cases
//     Now what i think is, we need to find the minimum distance to reach a point x out of all the avaialble points excluding itself
//     How to do it?
    
//     */
// }
class Solution {
    // int[] parent;
    // public Solution(){
    //     parent=new int[points.length];
    //     for (int i = 0; i < points.length; i++) parent[i] = i;

    // }

    public int minCostConnectPoints(int[][] points) {
    List<int[]> edges=new ArrayList<>();
    for(int i=0;i<points.length;i++){
        for(int j=i+1;j<points.length;j++){
            int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            edges.add(new int[]{i,j,dist});
        }
    }
     //sort edges on the basis of distance
    edges.sort((a,b)->a[2]-b[2]);
    UnionFind uf=new UnionFind(points.length);

    int distance=0;
    for(int[] edge:edges){
        int u=edge[0],v=edge[1],d=edge[2];
        if(uf.findParent(u)!=uf.findParent(v)){
            uf.createEdge(u,v);
            distance+=d;
        }
    }

    return distance;
}

}

class UnionFind{
    int[] parent;

    public UnionFind(int size){
        parent=new int[size];
        for(int i=0;i<size;i++) parent[i]=i;
    }

    
   private int findParent(int node){
    if(parent[node]==node){
        return node;
    }

    return findParent(parent[node]);
   }

   private void createEdge(int u,int v){
    int parentOfU=findParent(u);
    int parentOfV=findParent(v);
    if(parentOfU!=parentOfV) parent[parentOfU]=parentOfV;

   } 
}