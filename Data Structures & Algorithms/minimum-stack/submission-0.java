class MinStack {
Stack<Integer> stack;
// int min=Integer.MAX_VALUE;
    public MinStack() {
        stack=new Stack<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
        // min=Math.min(min,val);
    }
    
    public void pop() {
        if(!stack.isEmpty())
        stack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }
    
    public int getMin() {
        Stack<Integer> tempStack=new Stack<>();
int min=Integer.MAX_VALUE;
        while(!stack.isEmpty()){
            tempStack.push(stack.peek());
min=Math.min(min,stack.pop());

        }

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return min;
    }
}
