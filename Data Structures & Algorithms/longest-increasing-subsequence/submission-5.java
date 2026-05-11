class Solution {
    int memo[][];
    public int lengthOfLIS(int[] nums) {
        memo=new int[nums.length][nums.length+1];
        for(int i=0;i<memo.length;i++){
        Arrays.fill(memo[i],-1);

        }
        return memofn(nums,-1,0);
    }

    private int memofn(int[] nums,int prev,int curr){
        if(curr==nums.length) return 0;

        if(memo[curr][prev+1]!=-1) return memo[curr][prev+1];

        int take=0,skip=0;
        if(prev==-1||nums[curr]>nums[prev]){
            take=1+memofn(nums,curr,curr+1);
        }
        skip=memofn(nums,prev,curr+1);
        return memo[curr][prev+1]=Math.max(take,skip);
    }

}
