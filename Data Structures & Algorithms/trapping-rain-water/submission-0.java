class Solution {
    public int trap(int[] height) {
        int[] prefixMaxHeight=new int[height.length+1];
        int[] suffixMaxHeight=new int[height.length+1];

        prefixMaxHeight[0]=0;suffixMaxHeight[height.length]=0;

        //filling prefix array - calculating max height for a particular index to the left of that index
        for(int i=0;i<height.length;i++){
            prefixMaxHeight[i+1]=Math.max(prefixMaxHeight[i],height[i]);
        }


        //filling suffix array - calculating max height for a particular index to the right of that index
        for(int i=height.length-1;i>=0;i--){
            suffixMaxHeight[i]=Math.max(suffixMaxHeight[i+1],height[i]);
        }

        //calculate trapped water while traversal 
        int trappedWater=0;
        for(int i=0;i<height.length;i++){
            int currWater=Math.min(prefixMaxHeight[i],suffixMaxHeight[i])-height[i];
            trappedWater+=currWater>0?currWater:0;
        }

return trappedWater;

    }
}
