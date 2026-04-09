class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //second approach
        //optimized 
        //disjoint set approach
        //it has 2 functions-
        /*
        1. Finding ultimate parent
        2. Finding union

        Given an edge (x,y)
        In union function, we simply find the ultimate parent of both the given nodes. We can also say that it is the common ancestor of both nodes and not just the next level parent 
        If the ultimate parent is same for both, we have found the cycle on the edge of those nodes and hence that edge is the additional edge causing the cycle
        Otherwise, we set the parent of x with y
        
        In find parent function, we find the ultimate parent of both the nodes. To find the ultimate parent, if the parent of a given node is the node itself, it means that node is the ancestral boss
        Otherwise, we need to keep on finding the parent of a given node until we meet the parent boss

        */

        int[] parent=new int[edges.length+1];
        for(int i=0;i<=edges.length;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            if(union(edge[0],edge[1],parent)){
                return edge;
            }
        }
        return new int[0];
    }

    private boolean union(int x,int y,int[] parent){
        int parentOfX=findUltimateParent(x,parent);
        int parentOfY=findUltimateParent(y,parent);

        if(parentOfX==parentOfY){
            return true;        //has cycle
        }

        parent[parentOfX]=parentOfY;
        return false;
    }

    private int findUltimateParent(int node,int[] parent){
        if(node==parent[node]){
            return node;
        }

        parent[node]=findUltimateParent(parent[node],parent);
        return parent[node];
    } 


}
