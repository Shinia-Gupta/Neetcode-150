class Solution {
    //BACKTRACKING APPROACH
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        subsetsHelper(nums,res,new ArrayList<>(),0);
        return res;
    }
private void subsetsHelper(int[] nums,List<List<Integer>> res, List<Integer> currSubset,int index){
    if(index>=nums.length){
        res.add(new ArrayList<>(currSubset));
        return; 
    }
currSubset.add(nums[index]);   
subsetsHelper(nums,res,currSubset,index+1); 
currSubset.remove(currSubset.size()-1);
subsetsHelper(nums,res,currSubset,index+1);

}

}
