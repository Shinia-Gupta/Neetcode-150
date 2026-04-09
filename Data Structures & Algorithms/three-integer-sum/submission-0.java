class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
HashSet<List<Integer>> set=new HashSet<>();
Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int newTarget= 0-nums[i];
            int j=i+1,k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==newTarget){
set.add(Arrays.asList(nums[i],nums[j],nums[k]));
j++;k--;
                }else if(nums[j]+nums[k]<newTarget){
                    j++;
                }else{
                    k--;
                }

            }
        }
        return new ArrayList<>(set);
    }
}
