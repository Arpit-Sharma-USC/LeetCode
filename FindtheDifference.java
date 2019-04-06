class Solution {
    public char findTheDifference(String s, String t) 
    {
        int sumS = 0;
        int sumT = 0;
        
        for (char c : s.toCharArray())
        {
            sumS+=(int)c;
        }
        
        for (char c : t.toCharArray())
        {
            sumT+=(int)c;
        }
        
        return (char)(sumT-sumS);
        
    }
}
