class Solution {
    public int findDuplicate(int[] nums) {
        // int[] linkedCycle=new int[nums.length+1];
        // linkedCycle[0]=0;
        // for(int i=0;i<nums.length;i++){
        //     linkedCycle[i+1]=nums[nums[i]];
        // }

        //first meet of fast and slow pointers
        int fast=0,slow=0;
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast){
                break;
            }
        }
        int slow2=0;
        while(true){
            slow=nums[slow];
            slow2=nums[slow2];
            if(slow==slow2){
                return slow;
            }
        }
        // return -1;
    }
}
