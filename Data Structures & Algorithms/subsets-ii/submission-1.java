class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums,0);
        return res;
    }

    private void backtrack(List<List<Integer>> res,List<Integer> subset,int[] nums,int i){
        if(i>=nums.length){
            return;
        }

        subset.add(nums[i]);
        backtrack(res,subset,nums,i+1);
        List<Integer> newList=new ArrayList<>(subset);
        newList.sort((a,b)->a-b);
        if(!res.contains(newList))
        res.add(newList);

        subset.remove(subset.size()-1);
        backtrack(res,subset,nums,i+1);
        List<Integer> newList2=new ArrayList<>(subset);
        newList2.sort((a,b)->a-b);
        if(!res.contains(newList2))
        res.add(newList2);
    }
}
