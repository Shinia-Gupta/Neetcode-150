class Solution {
    public int rob(int[] nums) {
        //2 choices - i either consider 
        // house 1
        //or house last
        // so considering each of the choices one by one, i get the max amount of each of them
        // finally i return the max of the 2 results
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        return Math.max(rec(nums,0,nums.length-2,dp),rec(nums,1,nums.length-1,dp));
    }

    private int rec(int[] nums,int start,int end, int[] dp){
        // int dp[]=new int[end-start+1];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[end];
    }
}
