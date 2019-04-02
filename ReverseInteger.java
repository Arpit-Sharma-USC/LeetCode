class Solution {
    public int reverse(int x) {
         int INT_MAX_OVER_10 = Integer.MAX_VALUE/10;
         int INT_MIN_OVER_10 = Integer.MIN_VALUE/10;
        
        int rev=0; 
        while(x!=0)
        {
           int pop= x%10;
            x/=10;
            
            if((rev>INT_MAX_OVER_10) ||(rev==INT_MAX_OVER_10&&pop>7)) return 0;
            if((rev<INT_MIN_OVER_10) ||(rev==INT_MIN_OVER_10&&pop<-8)) return 0;

            rev=  rev *10 + pop;
        }
        return rev;
    }
}
