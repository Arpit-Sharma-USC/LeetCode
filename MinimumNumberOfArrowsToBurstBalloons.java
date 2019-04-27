class Solution{
    public int findMinArrowShots(int[][] points)
    {
        if(points==null||points.length==0)
            return 0;
        
        Arrays.sort(points, new Comparator<int[]>(){
            @Override public int compare(int[] a,int[] b)
            {
                return a[1]-b[1];
            }
        });
        
        int curr = points[0][1];
        int balloons=1;
        
        for(int i = 0 ; i< points.length;i++)
            if(points[i][0]>curr)
            {
                curr=points[i][1];
                balloons++;
            }
        
        return balloons;
    }
}
