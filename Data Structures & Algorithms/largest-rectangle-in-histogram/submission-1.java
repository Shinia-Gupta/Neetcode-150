class Solution {
    //arrays to store the INDICES of next smallest and previous smallest elements
static int[] prevSmallestBar;
static int[] nextSmallestBar;
    private static void nextSmallestBarFn(int[] heights){
nextSmallestBar=new int[heights.length];
Stack<Integer> stack=new Stack<>();

for(int i=heights.length-1;i>=0;i--){
int curr=heights[i];
while(!stack.isEmpty() && curr<=heights[stack.peek()]){
    stack.pop();
}
nextSmallestBar[i]=stack.isEmpty()?heights.length:stack.peek();
stack.push(i);
}
    }

    private static void prevSmallestBarFn(int[] heights){
prevSmallestBar=new int[heights.length];
Stack<Integer> stack=new Stack<>();

for(int i=0;i<heights.length;i++){
int curr=heights[i];
while(!stack.isEmpty() && curr<=heights[stack.peek()]){
    stack.pop();
}
prevSmallestBar[i]=stack.isEmpty()?-1:stack.peek();
stack.push(i);
}
    }

    public int largestRectangleArea(int[] heights) {
        nextSmallestBarFn(heights);
        prevSmallestBarFn(heights);
        int largestRectangle=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int length=nextSmallestBar[i]-prevSmallestBar[i]-1;
            int height=heights[i];
            int area=length*height;
            
            largestRectangle=Math.max(area,largestRectangle);
        }
        return largestRectangle;
    }
}
