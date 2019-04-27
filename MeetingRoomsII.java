class Solution{
    public int minMeetingRooms(int[][] intervals)
    {
        if(intervals == null|| intervals. length ==0)
            return 0;
        int len = intervals.length;
        int[] start = new int[len] ;
        int[] end = new int[len];
        
        
        for(int i = 0 ; i < len;i++)
        {
            start[i]= intervals[i][0];
            end[i]= intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int start_ptr,end_ptr, rooms;
        start_ptr=end_ptr=rooms=0;
        
        while(start_ptr< len)
        {
            if(start[start_ptr]>=end[end_ptr])
            {
                rooms--;
                end_ptr++;
            }
            rooms++;
            start_ptr++;
        }
        
        return rooms;
    }
}

//With Priority Queue

class Solution_my {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length==0 || intervals == null)
            return 0;
        
        PriorityQueue<Integer> myQ = new PriorityQueue<Integer>(intervals.length);
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override 
            public int compare(int[] a ,int[] b)
            {
                return a[0]-b[0];
            }
        });
         
        myQ.add(intervals[0][1]);
        
        for(int i = 1; i < intervals.length;i++)
        {
            if(myQ.peek()<=intervals[i][0])
                myQ.poll();
            
            myQ.add(intervals[i][1]);
        }
        
        return myQ.size();
    }
}
