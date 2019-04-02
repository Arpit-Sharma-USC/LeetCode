class Solution {


public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> results = new ArrayList<>();
    
    Arrays.sort(nums);
    
    for(int i = 0 ; i +2 < nums.length; i++)
    {
        if(i>0 && nums[i-1]==nums[i])
            continue;
        
        int target = -nums[i];
        int start,end;
        start = i+1;
        end = nums.length-1;
        
        while(start < end)
        {
            if(nums[start]+nums[end] == target)
            {
                results.add(Arrays.asList(nums[i],nums[start],nums[end]));
                start++;
                end--;
                
                while(start<end && nums[start]==nums[start-1])
                    start++;
                while(start<end && nums[end]==nums[end+1])
                    end--;
                
            }
            else if(nums[start]+nums[end]>target)
                end--;
            else
                start++;
        }
    }
    
    return results;
}  
}

