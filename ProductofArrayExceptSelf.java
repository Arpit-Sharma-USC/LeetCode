class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0]=1;
        for(int i=1; i <n;i++)
            res[i]=res[i-1]*nums[i-1];
        
        int right_side=1;
        for(int i =n-1;i>-1;i--)
        {
            res[i]=res[i]*right_side;
            right_side=right_side*nums[i];
        }
        
            return res;
    }
}
//with division

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int prod_total=1;
        int flag_z=0;
        res[0]=1;
        
         int zeroCount = 0;
        int zeroIndex = -1;

        
  
        for(int i=0; i <n;i++)
            if(nums[i]!=0)
            {
                prod_total*=nums[i];
            
            }
            else
            {
                zeroIndex = i;
                zeroCount++;
             }            
        
        
           if (zeroCount >= 1)
         {
            for (int i = 0; i < n; i++)
            {
                nums[i] = 0;
            }
            if (zeroCount == 1)
            {
                nums[zeroIndex] = prod_total;
            }
            return nums;
       }
    
        for(int i=0; i <n;i++)
        {
          
                res[i]=(int)(prod_total/nums[i]);
            
        }
        
        return res;
    }
}
