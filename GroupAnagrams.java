class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
      List<List<String>> answer= new ArrayList<>();
        
        Map<String,List<String>> myMap = new HashMap<>();
        
        for(String s : strs)
        {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted =  new String(chars);
            
            if(!myMap.containsKey(sorted))
                myMap.put(sorted,new ArrayList<>());
            
            myMap.get(sorted).add(s);
        }
        
        answer.addAll(myMap.values());
        
        return answer;
        
        
        
    }
}
