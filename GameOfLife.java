class Solution {
public void gameOfLife(int[][] board) {
  int m,n;
    m=board.length;
    if(m>0)
        n=board[0].length;
    else
        n=0;
    
    int dx[]={-1,-1,-1,0,0,1,1,1};
    int dy[]={-1,0,1,-1,1,-1,0,1};
    
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
            int lives=0;
            for(int k=0;k<8;k++)
            {
                int i_p,j_p;
                i_p = dx[k]+i;
                j_p = dy[k]+j;
                if(i_p<0||i_p>=m||j_p<0||j_p>=n)
                    continue;
                if(board[i_p][j_p]==1||board[i_p][j_p]==2)
                    lives++;
                
            }
            if(board[i][j]==1 &&(lives<2||lives>3))
                board[i][j]=2;
            else if(board[i][j]==0 && lives ==3)
                board[i][j]=3;
        }
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
            board[i][j]%=2;
}
}
