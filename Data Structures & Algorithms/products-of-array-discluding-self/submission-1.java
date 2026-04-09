class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProdExceptSelf=new int[nums.length];
        int[] suffixProdExceptSelf=new int[nums.length];
        int[] output=new int[nums.length];
        Arrays.fill(prefixProdExceptSelf,1);
                Arrays.fill(suffixProdExceptSelf,1);

prefixProdExceptSelf[0]=1;
suffixProdExceptSelf[nums.length-1]=1;

        for(int i=1;i<nums.length;i++){
            prefixProdExceptSelf[i]=prefixProdExceptSelf[i-1]*nums[i-1];
            System.out.print("prefix prod--"+prefixProdExceptSelf[i]);
            System.out.println();
        }
        for(int i=nums.length-2;i>=0;i--){
            suffixProdExceptSelf[i]=suffixProdExceptSelf[i+1]*nums[i+1];
            System.out.print("suffix prod--"+suffixProdExceptSelf[i]);
            System.out.println();
        }

        for(int i=0;i<nums.length;i++){
            output[i]=prefixProdExceptSelf[i]*suffixProdExceptSelf[i];
        }

        return output;
    }
}  
