class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> myMap = new HashMap<>();
        
        for(String temp: words)
        {
            myMap.put(temp,myMap.getOrDefault(temp,0)+1);
        }
        
        for(Map.Entry<String,Integer> entry : myMap.entrySet())
            System.out.println(entry.getKey()+":"+entry.getValue());
        
        PriorityQueue<String> heap = new PriorityQueue<String>((n1,n2)->myMap.get(n2).equals(myMap.get(n1))?n1.compareTo(n2):(myMap.get(n2)-myMap.get(n1)));
        
  
        for(String temp: myMap.keySet())
        {
            heap.add(temp);
  
        }
              
        List<String> answer = new ArrayList<>();
        
        while(k>0)
        {
            answer.add(heap.poll());
            k--;
        }
        return answer;
    }
}
