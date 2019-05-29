class Solution {
    public int minFallingPathSum(int[][] A) {
        
        for(int i =A.length-2;i>=0;i--)
        {
            for(int j =A.length-1;j>-1;j--)
            {
            
                int best = A[i+1][j];
                if(j>0)
                    best=Math.min(best,A[i+1][j-1]);
                
                if(j<A.length-1)
                    best=Math.min(best,A[i+1][j+1]);
                
                A[i][j]+=best;
            }
            
        }
        int res=Integer.MAX_VALUE;
        for(int first:A[0])
            res=Math.min(res,first);
        
        return res;
        
    }
}
