class Solution {
    public String convert(String s, int numRows) {
    
     int length=s.length();
        if(length<=numRows || numRows<2)
            return s;
        
        char[] ZZ = new char[length];
        int count=0;
        int interval= 2*numRows-2;
        for(int i =0;i<numRows;i++)
        {
            int step = interval-2*i;
            for(int j = i; j<length;j+=interval)
            {
                ZZ[count++] = s.charAt(j);
                if(step>0 && step<interval &&(j+step)<length)
                    ZZ[count++] = s.charAt(j+step);
            }
        }
        return new String(ZZ);
}
}
