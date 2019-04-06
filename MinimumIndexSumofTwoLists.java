class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> list1_map = new HashMap<>();
        List<String> answer=new ArrayList<>();
        int count=0;
        for(int i=0;i<list1.length;i++)
            list1_map.put(list1[i],i);
        
        int min_sum = Integer.MAX_VALUE;
        int answer_id=0;
        for(int i =0;i<list2.length;i++)
        {
            if(list1_map.containsKey(list2[i]))
                if(min_sum>(list1_map.get(list2[i])+i))
                {    
                    min_sum = list1_map.get(list2[i])+i;
                    answer.clear();
                    answer.add(list2[i]);
                }
                else if(min_sum==(list1_map.get(list2[i])+i))
                {
                    min_sum = list1_map.get(list2[i])+i;
                    answer.add(list2[i]);
                    
                }
        }
        
        
          return answer.toArray(new String[answer.size()]);  
    }
}
