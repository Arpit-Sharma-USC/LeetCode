class Solution {
    public int maxArea(int[] height) {
        int left,right,maxArea;
        left=right=maxArea=0;
        right=height.length-1;
        while(left<right)
        {
            maxArea=Math.max(maxArea,((right-left)*Math.min(height[left],height[right])));
            if(height[left]<height[right])
                left++;
            else
                right--;
            
            
        }
        return maxArea;
        
        
    }
}
