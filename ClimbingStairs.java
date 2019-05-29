class Solution {
    public int climbStairs1(int n) {
        double sq5= Math.sqrt(5);
      
        return (int) ((Math.pow((1+sq5)/2,n+1)-Math.pow((1-sq5)/2,n+1))/sq5);
    }
    
    public int climbStairs(int n)
    {
        if(n==1)
            return 1;
        
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i =3;i<n+1;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
