class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       HashSet<List<Integer>> uniqueCombos=new HashSet<>();
       combinationSum(uniqueCombos,new ArrayList<>(),candidates,target,0);
        // HashSet<List<Integer>> uniqueCombos=new HashSet<>(result);
        List<List<Integer>> result=new ArrayList<>(uniqueCombos);
        return result;
    }

    private void combinationSum(HashSet<List<Integer>> uniqueCombos,List<Integer> currSublist, int[] candidates, int target,int index){
        if(target==0){
            List<Integer> temp=new ArrayList<>(currSublist);
            temp.sort((a,b)->a-b);
            uniqueCombos.add(temp);
            return;
        }

        if(target<0|| index>=candidates.length){
            return;
        }

        currSublist.add(candidates[index]);
        combinationSum(uniqueCombos,currSublist,candidates,target-candidates[index],index+1);
        currSublist.remove(currSublist.size()-1);
        combinationSum(uniqueCombos,currSublist,candidates,target,index+1);


    }
}
