class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        /*
        state=starting at an index, in how many ways can i achieve a given target 
        reccurence= if(currSum+(nums[i])<=target) rec(i+1,currSum+nums[i])
        if(currSum-nums[i]<=target) rec(i+1,currSum-nums[i])
        if(currSum==target) numOfWays+1;OR if(target==0) numOfWays+1;
        currsum>target?return 0;-> wrong coz curSum is alowed to go outdde the scope of target once until we are finished processing all the numbers i.e we definitely need to use all the numbers in the array
        */

        return rec(nums,target,0);
    }

    private int rec(int[] nums,int target,int i){
        if(i==nums.length) return target==0?1:0;

        int numAdd=rec(nums,target-nums[i],i+1);
        int numSub=rec(nums,target+nums[i],i+1);

        return numAdd+numSub;
    }
}
