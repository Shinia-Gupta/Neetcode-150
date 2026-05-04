class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];

        //this condition is sloppy as even though the constraints say that number of houses are >=1, to create an edge case, if no houses, i.e 0 houses present, return 0
        // if(nums.length<=1) return nums[0];

        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        // ye max toh humne for ecah house ya till each index, loop mei hi store krlkia tha, toh ismei max dekhne ki zarurat nhi h
        return dp[nums.length-1];
    }
}
