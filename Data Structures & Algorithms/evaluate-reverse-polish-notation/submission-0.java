class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String token=tokens[i];
            if(!token.equals("+") && !token.equals("/") && !token.equals("*") && !token.equals("-")){
                stack.push(token);
            }else {
                evalExpression(stack,token);
        }
        }
        return Integer.parseInt(stack.pop());
    }

    private static void evalExpression(Stack<String> stack,String token){
int result=0,elem1=Integer.parseInt(stack.pop()),elem2=Integer.parseInt(stack.pop());
        switch(token){
            case "+":
result=elem1+elem2;
                break;
            case "-":
                result=elem2-elem1;
                break;
            case "*":
            result=elem1*elem2;
                break;
            case "/":
            result=elem2/elem1;
                break;
            default:
            System.out.println("Invalid token");
                break;
        }
                stack.push(String.valueOf(result));


    }
}
