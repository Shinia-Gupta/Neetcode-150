class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0,nums.length-1,nums,nums.length-k);
    }

    private int quickSelect(int l,int r,int[] nums, int kIndex){
        int pivot=nums[r];
        int p=l;

        for(int i=l;i<r;i++){
            if(nums[i]<=pivot){
                int temp=nums[p];
                nums[p]=nums[i];
                nums[i]=temp;
                p++;
            }
        }
        int temp=nums[p];
        nums[p]=pivot;
        nums[r]=temp;

        if(p>kIndex){
            return quickSelect(l,p-1,nums,kIndex);
        }else if(p<kIndex){
            return quickSelect(p+1,r,nums,kIndex);
        }else{
            return nums[p];
        }
    }
}
