class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer=new ArrayList<>();
        
        backtrack(answer,"",0,0,n);
        
        return answer;
    }
    private void backtrack(List<String> answer, String curr, int open , int close, int max)
    {
        if(curr.length()==2*max)
        {
            answer.add(curr);
            return;
        }
        if(open<max)
            backtrack(answer,curr+"(",open+1,close,max);
        
        if(close<open)
            backtrack(answer,curr+")",open,close+1,max);
    }
}
