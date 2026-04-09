class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> res=new ArrayList<>();
       StringBuilder str=new StringBuilder();
       partitionHelper(res,s,0,new ArrayList<String>());
       
       return res;
    }

    private void partitionHelper(List<List<String>> res,String str,int start,List<String> sublist){
if(start==str.length()){
     res.add(new ArrayList<>(sublist));
     return;
}

for(int end=start;end<str.length();end++){
if(isPalindrome(str.substring(start,end+1))){
    sublist.add(str.substring(start,end+1));
    partitionHelper(res,str,end+1,sublist);
    sublist.remove(sublist.size()-1);
}

}

    }

    private boolean isPalindrome(String str){
        int i=0,j=str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
