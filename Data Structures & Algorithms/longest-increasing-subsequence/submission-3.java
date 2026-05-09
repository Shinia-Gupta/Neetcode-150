class Solution {
        int[][] dp;
    public int lengthOfLIS(int[] nums) {
        /*
        dp array is a 2d array - representing the LIS length starting at current index when particular previous value is selected 
        decisions - whether to take the current number or skip it 
                - we can only take the current number if there is no prev value selected or the curr number is greater than the prev selected value
                - otherwise we can directly consider skipping the number without any specfic conditions
        f(curr,prev)= returns the LIS provided the curr number and the prev selected number for that current number
        recurrence =>
        take=1+f(curr+1,curr)
        skip=f(curr+1,prev)
        max(take,skip) => means at current index, we are returning the LIS length possible by either considering the current value or by skipping it          
        */
        dp=new int[nums.length][nums.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return memo(nums,0,-1);
    }

    private int memo(int[] nums,int curr,int prev){
        if(curr==nums.length){
            return 0;
        }

        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];

        int take=0,skip=0;
        if(prev==-1||nums[curr]>nums[prev]){
            take=1+memo(nums,curr+1,curr);
        }

        skip=memo(nums,curr+1,prev);
        
        return dp[curr][prev+1]= Math.max(take,skip);
    }
}
