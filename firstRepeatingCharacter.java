class Solution {
    public int firstUniqChar(String s) {
      int[] bitmap = new int[256];
        for(int i =0;i<256;i++)
            bitmap[i]=-1;
        int res= Integer.MAX_VALUE;
        for(int i = 0 ; i < s.length();i++)
        {
            if(bitmap[s.charAt(i)]==-1)
            { bitmap[s.charAt(i)]=i;
             System.out.println(bitmap[s.charAt(i)]);
        }
            else
                res=Math.min(res,bitmap[s.charAt(i)]);
        }
                     System.out.println(res);

        return res==Integer.MAX_VALUE?0:res;
    }
}
