class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>(); 
        // for(int i=0;i<nums.length;i++){
            List<Integer> sublist=new ArrayList<>();
            // sublist.add(nums[i]);
            // HashSet<Integer> set=new HashSet<>();
            backtrack(nums,sublist,result);
        // }
        return result;
    }
    private void backtrack(int[] nums,List<Integer> sublist, List<List<Integer>> result ){
            if(sublist.size()==nums.length) {
                result.add(new ArrayList<>(sublist));
            return;
            }
for(int i=0;i<nums.length;i++){
// if(consideredIndex!=ongoingIndex){
            if(sublist.contains(nums[i])) continue;
            
        
                sublist.add(nums[i]);
                // set.add(nums[i]);
            backtrack(nums,sublist,result);
            // }else{
            // set.remove(sublist.get(sublist.size()-1));
            sublist.remove(sublist.size()-1);
            // backtrack(nums,sublist,result);

            }
        // }


}
        


    
}
