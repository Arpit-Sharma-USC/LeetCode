class Solution {
    public int shortestSubarray(int[] A, int K) {
        
        int n =A.length;
        long[] B= new long[n+1];
        for(int i =0;i<n;i++)
            B[i+1]=B[i]+A[i];
        
        Deque<Integer>  Q =new LinkedList();
        int ans=n+1;
        for(int y=0;y<n+1;y++)
        {
            while(!Q.isEmpty() && B[y]<=B[Q.getLast()])
                Q.removeLast();
            while(!Q.isEmpty() && B[y]-B[Q.getFirst()]>=K)
                ans=Math.min(ans,y-Q.removeFirst());
            
            Q.addLast(y);
        }
        
        return ans<n+1?ans:-1;
    }
}
