class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //we would like a build up a max heap
        //In a max heap the root is the largest element
        //followed by the 2nd largest
        //and so on till the leaf, 
        // where leaf is the nth largest element in a heap of size n
        
        PriorityQueue<Integer> heap = new  PriorityQueue<Integer>((n1,n2)->(n2-n1));
        
        for(int temp:nums)
            heap.add(temp);
        
        // Now we have built our max heap
        
        int answer = 0;
        
        while( k > 0 )
        {
            
            if(k==1)
                answer = heap.poll();
            else 
                heap.poll();
            k--;
        }
        
        return answer;
    }
}


/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return nums[quickSelect(nums, 0, nums.length-1, nums.length-k+1)];
    }
    
    private int quickSelect(int[]nums, int lo, int hi, int k){
        int i = lo, j = hi, mid = i + (j-i)/2, pivot = nums[mid];
        swap(nums,mid,hi);
        while(i < j){
            if(nums[i++] > pivot) 
                swap(nums,--i, --j);
        }
        swap(nums,i,hi);
        int m = i - lo + 1;
        if(m == k) return i;
        if(m > k) return quickSelect(nums, lo, i-1, k);
        else return quickSelect(nums, i+1, hi, k-m);
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
} 
*/
