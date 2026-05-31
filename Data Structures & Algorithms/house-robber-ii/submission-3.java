class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] arr1=Arrays.copyOfRange(nums,0,nums.length-1);
        int[] arr2=Arrays.copyOfRange(nums,1,nums.length);
        int memo1[]=new int[nums.length];
        Arrays.fill(memo1,-1);
        int memo2[]=new int[nums.length];
        Arrays.fill(memo2,-1);
        
        return Math.max(rec(arr1,0,memo1),rec(arr2,0,memo2));
    }

    private int rec(int[] arr,int i,int memo[]){
        if(i>=arr.length)return 0;
        if(memo[i]!=-1) return memo[i];
        int pickHouse=arr[i]+rec(arr,i+2,memo);
        int notPickHouse=rec(arr,i+1,memo);

        return memo[i]=Math.max(pickHouse,notPickHouse);
    }
}
