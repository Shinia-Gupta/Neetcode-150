class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backtracking(nums,target,res,0,new ArrayList<>() );
        return res;
    }

    private void backtracking(int[] nums,int target,List<List<Integer>> res,int index,List<Integer> currSublist){
        if(target==0){
            res.add(new ArrayList<>(currSublist));
            return;
        }

        if(target<0||index>=nums.length){
            return;
        }

        currSublist.add(nums[index]);
        backtracking(nums,target-nums[index],res,index,currSublist);
        currSublist.remove(currSublist.size()-1);
        backtracking(nums,target,res,index+1,currSublist);

    }
}
