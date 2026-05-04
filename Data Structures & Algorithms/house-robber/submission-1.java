class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        return rec(nums,nums.length-1);
    }

    private int rec(int[] nums,int i){
        if(i==0) return nums[0];
        if(i==1) return Math.max(nums[0],nums[1]);
        if(memo[i]!=-1) return memo[i];
        return memo[i]=Math.max(nums[i]+rec(nums,i-2),rec(nums,i-1));
    }
}
