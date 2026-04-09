class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }

        List<int[]> resList=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
        resList.add(new int[]{entry.getValue(),entry.getKey()});
        }
        resList.sort((a,b)->b[0]-a[0]); //sort the list based on the frequency of each array's value attribute(not the key)
        int[] resArray=new int[k];
        for(int i=0;i<k;i++){
            resArray[i]=resList.get(i)[1];
        }
        return resArray;
    }
}
