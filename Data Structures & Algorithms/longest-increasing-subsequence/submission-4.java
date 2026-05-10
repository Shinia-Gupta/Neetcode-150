class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
        //values of curr span from 0 to n-1 and values of prev span from -1 to curr-1
        
        for(int curr=nums.length-1;curr>=0;curr--){
            for(int prev=curr-1;prev>=-1;prev--){
                int take=0,skip=0;
                if(prev==-1||nums[curr]>nums[prev]){
                    take=1+dp[curr+1][curr+1];
                }

                skip=dp[curr+1][prev+1];
                dp[curr][prev+1]=Math.max(take,skip);
            }
        }
        return dp[0][0];
    }
}
