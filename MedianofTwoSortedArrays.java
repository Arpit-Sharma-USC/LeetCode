class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
   
        int x,y;
      
        
        if(nums1.length>nums2.length)
        {
            //make X array the one with fewer elements
            int[] temp = nums1;
            nums1=nums2;
            nums2=temp;
        }
        x=nums1.length;
        y=nums2.length;
        
        int low = 0;
        int high = x;
       
        
        
        while(low <= high)
        {
            int x_partition = (low+high)/2;
            int y_partition = (x+y+1)/2 - x_partition;
            
            int xMaxLeft = (x_partition==0)? Integer.MIN_VALUE: nums1[x_partition-1];
            int xMinRight = (x_partition==x)? Integer.MAX_VALUE: nums1[x_partition];

            int yMaxLeft = (y_partition==0)? Integer.MIN_VALUE: nums2[y_partition-1];
            int yMinRight = (y_partition==y)? Integer.MAX_VALUE: nums2[y_partition];
            
            
            if(xMaxLeft <= yMinRight && yMaxLeft <= xMinRight)
            {
                if((x+y)%2==0)
                   return ((double)Math.max(xMaxLeft, yMaxLeft) + Math.min(xMinRight, yMinRight))/2;

                else
                  return ((double)(Math.max(xMaxLeft,yMaxLeft)));
            }
            else if(xMaxLeft>yMinRight) 
                high = x_partition - 1;
            else
                low = x_partition + 1;
    
        }
        throw new IllegalArgumentException();
        }
    
 
}
