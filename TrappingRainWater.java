class Solution {
    public int trap(int[] height) {
        
        int max_l,max_r,left,right,answer;
        answer=max_l=max_r=left=0;
        right=height.length-1;
        
        while(left<right)
        {
            if(height[left]<height[right])
            {
                if(max_l<height[left])
                    max_l=height[left];
                else
                    answer+=max_l-height[left];
                left++;
            }
            else
            {
                if(max_r<height[right]) 
                    max_r=height[right];
                else
                    answer+=max_r-height[right];
                right--;
            }
        }
        
        return answer;
    }
}
