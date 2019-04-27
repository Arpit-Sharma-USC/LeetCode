class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if(intervals==null || intervals.length ==0)
            return true;
        
        int len = intervals.length;
        
        int[] start = new int[len];
        int[] end = new int[len];
        
        for(int i = 0 ; i< len;i++)
        {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int start_ptr,end_ptr,rooms;
         start_ptr=end_ptr=rooms=0;
        
        while(start_ptr<len)
        {
            if(start[start_ptr]>=end[end_ptr])
            {
                rooms--;
                end_ptr++;

            }
            
                rooms++;
                start_ptr++;

        }
        if(rooms==1)
            return true;
        
        return false;
        
    }
}
