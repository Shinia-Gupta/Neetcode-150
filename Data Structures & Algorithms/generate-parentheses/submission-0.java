class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        backtrack(n,0,0,res,str);
        return res;
    }

    private void backtrack(int n,int openBrackets,int closeBrackets,List<String> res,StringBuilder str){
        if(openBrackets==n && closeBrackets==n) {
        res.add(str.toString());
        return;
        }
        if(openBrackets>n || closeBrackets>openBrackets){
            return;
        }
        str.append("(");
        backtrack(n,openBrackets+1,closeBrackets,res,str);
        str.deleteCharAt(str.length() - 1);
        str.append(")");
        backtrack(n,openBrackets,closeBrackets+1,res,str);
        str.deleteCharAt(str.length() - 1);

        
    }
}
