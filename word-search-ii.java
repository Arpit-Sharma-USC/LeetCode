class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> answer= new ArrayList<>();
        
        for(String each: words)
            if(exist(board,each))
                answer.add(each);
       return answer;
     
    }
    


    public boolean exist(char[][] board, String word) {
        
        for(int i =0;i<board.length;i++)
        { 
            for(int j =0;j<board[i].length;j++)
            {
                if(dfs(board,word,i,j,0))
                    return true;
                    
            }
        }
        
        return false;
        
    }
    
    private boolean dfs(char [][] board,String word,int i , int j , int step)
    {
        if(step==word.length())
            return true;
        if(i<0||i>=board.length||j>=board[i].length||j<0)
            return false;
        if((board[i][j]- word.charAt(step))!=0)
            return false;
        
        char record=board[i][j];
        board[i][j]='1';
        
        boolean answer=dfs(board,word,i+1,j,step+1)||dfs(board,word,i-1,j,step+1)||dfs(board,word,i,j+1,step+1)||dfs(board,word,i,j-1,step+1);
        
        board[i][j]=record;
        
        return answer;
        
            
    }
}
