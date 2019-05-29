class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        
        int[] dx=new int[]{-2,-2,-1,1,2,2,1,-1};
        int[] dy=new int[]{-1,1,2,2,1,-1,-2,-2};
        
        double[][] dp=new double[N][N];
        dp[r][c]=1;
        while(K>0)
        {
            double[][] dp2=new double[N][N];
            for(int i=0;i<N;i++)
                for(int j = 0 ; j<N;j++)
                    for(int k=0;k<8;k++)
                    {
                        int rr=i+dx[k];
                        int cc=j+dy[k];
                        if(rr>=0&&rr<N && cc>=0&&cc<N)
                            dp2[rr][cc]+=dp[i][j]/8.0;
                        
                    }
            dp=dp2;
            K--;
        }
        double sum=0.0;
        
        for(int i =0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                sum+=dp[i][j];
        return sum;
    }
}
