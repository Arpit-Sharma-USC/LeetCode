class Solution {
  /*scna all substring solution
  public int lengthOfLongestSubstring(String s) {
        
        int answer=0;
        for(int i =0;i<s.length();i++)
            for(int j = i+1;j<s.length()+1;j++)
                if(my_method_unique(s,i,j))
                    answer=Math.max(answer,j-i);
       return answer;
    }
    
    public boolean my_method_unique(String s , int start, int end)
    {
        Set<Character> mySet= new HashSet<>();
        for(int i = start;i<end;i++)
        {
            char ch = s.charAt(i);
            if(mySet.contains(ch))
                return false;
            mySet.add(ch);
        }
        
        return true;
        
    }
    
    */
    /* 2n window solution
        public int lengthOfLongestSubstring(String s) {
            
            int answer,i,j;
            answer=i=j=0;
            Set<Character> mySet= new HashSet<>();
            int n = s.length();
            
            while(i < n && j < n)
            {
                if(mySet.contains(s.charAt(j)))
                {
                    mySet.remove(s.charAt(i));
                    i++;
                }
                else 
                {
                    mySet.add(s.charAt(j));
                    j++;
                    answer=Math.max(answer,j-i);
                    
                }
            
            }
            
        return answer;    
        }
    
    */
        public int lengthOfLongestSubstring(String s) {
        
            Map<Character,Integer> myMap = new HashMap<>();
            int n = s.length();
            int answer=0;
            
            for(int j =0,i=0;j<n;j++)
            {   
                if(myMap.containsKey(s.charAt(j)))
                    i=Math.max(i,myMap.get(s.charAt(j)));
                
                answer=Math.max(answer, j+1-i);
                myMap.put(s.charAt(j),j+1);
            }
            
            return answer;
        }
  }
