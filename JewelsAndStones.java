class Solution {
    public int numJewelsInStones(String J, String S) {
        
        Map<Character,Integer> myMap = new HashMap<>();
        for(int i = 0 ;i<J.length();i++)
        {
            char ch = J.charAt(i); 
            if(myMap.containsKey(ch))
                myMap.put(ch,myMap.get(ch)+1);
            else
                myMap.put(ch,1);
        }
        
        int count = 0;
        for(int i = 0 ; i<S.length();i++)
        {
            char ch= S.charAt(i);
            if(myMap.containsKey(ch))
                count++;
        }
         
        return count;
    }
}
