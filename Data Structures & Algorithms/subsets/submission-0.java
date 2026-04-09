class Solution {
    //ITERATIVE APPROACH - TC- n*resSize- O(n*n)?...2^n subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num:nums){  //n times
            int size=res.size();
            for(int i=0;i<size;i++){    //res size times
                //creating a copy of the existing subsets in resultant arraylist
                List<Integer> subset=new ArrayList<>(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }
        return res;
    }
}
