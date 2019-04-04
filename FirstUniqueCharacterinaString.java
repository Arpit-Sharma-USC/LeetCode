class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer>  myMap = new HashMap<>();
        int n = s.length();
        
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(myMap.containsKey(ch))
                myMap.put(ch,myMap.get(ch)+1);
            else
                myMap.put(ch,1);
                
        }
        for(int i = 0 ; i< n;i++)
        {
            char ch= s.charAt(i);
            if(myMap.get(ch)==1)
                return i;
        }
         
        return -1;
    }
}
