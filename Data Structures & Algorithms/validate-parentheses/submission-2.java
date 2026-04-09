class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack=new Stack<>();
       if(s.length()%2!=0) return false;
       for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(c=='{'||c=='['||c=='(')
        {
            stack.push(c);
        }else if(c=='}'||c==')'||c==']'){
            if(!stack.isEmpty()){
                char popElem=stack.pop();
if(!(popElem=='[' && c==']'||popElem=='{' && c=='}'||popElem=='(' && c==')')){
    return false;
}
            }else{
                return false;
            }
        }
       } 
        return stack.isEmpty()?true:false;
    }
}
