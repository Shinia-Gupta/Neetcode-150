class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1) return nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxLength=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int streak=1;
                while(set.contains(nums[i]+streak)){
                        streak++;
                    
                }
                maxLength=Math.max(streak,maxLength);
            }
        }
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}
