class Solution { 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);         
        backtrack(nums,res,0,new ArrayList<>());         
        return res;     
        }      
    private void backtrack(int[] nums,List<List<Integer>> res,int start,List<Integer> subset){
         res.add(new ArrayList<>(subset));
          for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
        subset.add(nums[i]); 
        backtrack(nums,res,i+1,subset); 
        subset.remove(subset.size()-1);
        }     
        } 
        }