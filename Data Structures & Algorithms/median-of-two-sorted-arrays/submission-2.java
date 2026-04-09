class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //muje toh ye approach lag rhi h mind mei ki dono arrays ki length ka sum krlo
        //agar length even hai, toh median will be sum of 2 mid values/2
        //agar length odd h, toh median will be the mid element
        //par hum ye kaise nikalenge ki konsi 2 mid value hai, without intersecting the arrays...?

        //agar hum ye dekhe, ki dono arrays mei se kiski length kam h, toh jiski bhi length kam hogi, usmei median exist nhi kr sakta ...
        ///nhi, but aisa nhi h, agar hum ye consider kre 2 arrays- 1,2 and 1, toh mering them both will gie us 1,1,2 and median iska 1 hi rhega fir jo chote array se aaya hoga.
    
    
    // /correct one/*******************************************************************************************************************************
    // hume aise dekhna h ki median kab milta h, jab humei hmare left half mei half the total length of elements mil jaye, provided ki vo ye 2 conditions satisy krta ho--
    //left half of array A ka largest element<=right half of Array B ka smallest element
    //left half of array B ka largest element<= right half of array A ka smallest element

    //jab ye 2 conditions satisfy ho jaaye, toh hmara left partition sahi bna h, we can now opt for going into finding the median element.
    //ab based on the total length, 
    //agar length is even, toh median hoga  max(largest of left half of array A,largest of left half of array B)+min(smallest of right half of array A,smallest of right half of array B)
    //agar length is odd, toh left half ki next value dedo

//agar condition satisfy nhi hoti, toh hume chote array pe binary search lagake new mid nikalna pdega and fir uss mid tak ki length hmari new length hogi jisse hum bigger array ke half se minus krenge

if(nums1.length>nums2.length){
    return findMedianSortedArrays(nums2,nums1);
}

int n=nums1.length,m=nums2.length;
int leftHalfSize=(n+m+1)/2;
int l=0,r=n;

while(l<=r){
    int i=l+(r-l)/2;
    int j=leftHalfSize-i;

    int nums1Left=(i==0)?Integer.MIN_VALUE:nums1[i-1];
    int nums1Right=(i==n)?Integer.MAX_VALUE:nums1[i];
    
    int nums2Left=(j==0)?Integer.MIN_VALUE:nums2[j-1];
    int nums2Right=(j==m)?Integer.MAX_VALUE:nums2[j];

    //valid left half?
    if(nums1Left<=nums2Right && nums2Left<=nums1Right){

        //find median

        //if total length is odd
        if((n+m)%2==1){
            return Math.max(nums1Left,nums2Left);
        }

        int leftVal=Math.max(nums1Left,nums2Left);
        int rightVal=Math.min(nums2Right,nums1Right);
        return (leftVal+rightVal)/2.0;
    }else{
        if(nums1Left>nums2Right){
            r=i-1;
        }else{
            l=i+1;
        }
    }
}
return -1;

    }
}
