class Solution {
    
    public void custom_dfs(char[][] grid, int r, int c)
    {
        int tr,tc;
        
        tr=grid.length;
        tc=grid[0].length;
       
        if(r<0||c<0||r>=tr||c>=tc||grid[r][c]=='0')
            return;
        
        grid[r][c]='0';

        custom_dfs(grid,r+1,c);
        custom_dfs(grid,r-1,c);
        custom_dfs(grid,r,c+1);
        custom_dfs(grid,r,c-1);

    }
    
    public int numIslands(char[][] grid) {
        
        if(grid==null|| grid.length==0)
            return 0;
        int tr,tc;
        
        tr=grid.length;
        tc=grid[0].length;
        
        int count=0;
        
        for(int r=0;r<tr;r++)
            for(int c=0;c<tc;c++)
                if(grid[r][c]=='1')
                {
                    count++;
                    custom_dfs(grid,r,c);
                }
        return count;
    }
}
