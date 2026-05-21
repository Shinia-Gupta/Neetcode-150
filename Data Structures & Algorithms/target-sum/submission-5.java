class Solution {
    int[][] memo;
    public int findTargetSumWays(int[] nums, int target) {
        /*
        state=starting at an index, in how many ways can i achieve a given target 
        reccurence= if(currSum+(nums[i])<=target) rec(i+1,currSum+nums[i])
        if(currSum-nums[i]<=target) rec(i+1,currSum-nums[i])
        if(currSum==target) numOfWays+1;OR if(target==0) numOfWays+1;
        currsum>target?return 0;-> wrong coz curSum is alowed to go outdde the scope of target once until we are finished processing all the numbers i.e we definitely need to use all the numbers in the array
        */
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if(Math.abs(target) > totalSum)
            return 0;
        memo=new int[nums.length+1][2*totalSum+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        // for(int i=0;i<=nums.length;i++){
        //     memo[i][2*totalSum]=0;
        // }
        return memoised(nums,target,0,totalSum,0);
    }

    private int memoised(int[] nums,int target,int i,int totalSum,int currSum){
        if(i==nums.length) return currSum==target?1:0;
        if(memo[i][currSum + totalSum]!=Integer.MAX_VALUE) return memo[i][currSum + totalSum];

        int numAdd=memoised(nums,target,i+1,totalSum,currSum+nums[i]);
        int numSub=memoised(nums,target,i+1,totalSum,currSum-nums[i]);

        return memo[i][currSum + totalSum]=numAdd+numSub;
    }
}
