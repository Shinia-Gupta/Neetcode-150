class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<double[]> stack=new Stack<>();
        double[][] cars=new double[position.length][2];
        for(int i=0;i<position.length;i++){
             cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }

        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));

        for(int i=0;i<position.length;i++){
            double pos=cars[i][0];
            double timeToTarget=(double)(target-pos)/cars[i][1];
                stack.push(new double[]{pos,timeToTarget});
            if(stack.size()>=2 && stack.peek()[1]<=stack.get(stack.size()-2)[1]){
            stack.pop();
            }
                 }
         return stack.size();

    }
}
