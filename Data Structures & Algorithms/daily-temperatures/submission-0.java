class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //ALGORITHM USED - MONOTONICALLY DECREASING STACK

Stack<int[]> stack=new Stack<>();
int[] result=new int[temperatures.length];

for(int i=0;i<temperatures.length;i++){
    int temp=temperatures[i];
    while(!stack.isEmpty() && temp>stack.peek()[0]){
        int[] pair=stack.pop();
        result[pair[1]]=i-pair[1];
    }
    stack.push(new int[]{temp,i});
}
return result;
    }
}
