class Solution {
    public int largestSumAfterKNegations(int[] A, int k) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();//((n1,n2)->(n1-n2));
        
        for(int i = 0 ; i< A.length; i++)
            heap.add(A[i]);
        
        while(k-->0)
        {
            heap.add((-1)*heap.poll());
          //  k--;
        }
        int result=0;
        
        for(int temp:heap)
            result+=temp;
        
        return result;
    }
}
