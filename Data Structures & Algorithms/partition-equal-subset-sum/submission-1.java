class Solution {
    Boolean memo[][];
    public boolean canPartition(int[] nums) {
        /*
        state=starting at an index, is it possible to achieve the target sum?
        recurrence= if(nums[i]+nums[curr]<=targetsum) take=rec(nums[i]+currSumSoFar,i+1);
        skip=rec(currSumSoFar,i+1);
        recurrence=take||skip
        */
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        int targetSum=0;
        if(totalSum%2!=0) return false;
        targetSum=totalSum/2;
        memo=new Boolean[nums.length+1][targetSum+1];

        return memo(nums,0,targetSum,0);
    }

    private boolean memo(int[] nums,int i,int targetSum,int currSum){
        if(i==nums.length) return false;

        if(currSum==targetSum) return true;
        if(currSum>targetSum) return false;

        if(memo[i][currSum]!=null) return memo[i][currSum];
        
        boolean take=false,skip=false;
        
        if(currSum+nums[i]<=targetSum){
            take=memo(nums,i+1,targetSum,currSum+nums[i]);
        }

        skip=memo(nums,i+1,targetSum,currSum);
        return memo[i][currSum]=take||skip;
    }
}
