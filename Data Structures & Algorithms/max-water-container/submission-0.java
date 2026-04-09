class Solution {
    public int maxArea(int[] heights) {
      int maxWater=Integer.MIN_VALUE;
int j=heights.length-1,i=0;

      while (i<j){
        int height=Math.min(heights[i],heights[j]);
        int width=j-i;
        int currWater=height*width;
        if(heights[i]<=heights[j]){
            i++;
        }else{
            j--;
        }
        maxWater=Math.max(currWater,maxWater);
      }
      return maxWater;  
    }
}
