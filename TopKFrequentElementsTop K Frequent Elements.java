class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> myMap = new HashMap<>();
        
        List<Integer> answer= new ArrayList<>();
        
        int count=0;
        
        for(int i=0;i<nums.length; i++)
        {
            if(myMap.containsKey(nums[i]))
                myMap.put(nums[i],myMap.get(nums[i])+1);
            else
                myMap.put(nums[i],1);
        }
    
        PriorityQueue<Integer> heap= new PriorityQueue((n1,n2)->(myMap.get(n2)-myMap.get(n1))); //build a max heap
        
        for(int key_s: myMap.keySet())
            heap.add(key_s);
           
        
        //max heap is ready with size nums.length. Root has most frequency and leaves the least
        int counter =k;
        
        while(!heap.isEmpty()&& counter>0)
        {
            answer.add(heap.poll());
            counter--;
        }
        
      
        return answer;
    }
}
