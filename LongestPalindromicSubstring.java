class Solution {
    public String longestPalindrome(String s) {
        
        char[] T = new char[s.length()*2+3];
        T[0]='$';
        T[s.length()*2+2]='@';
        
        
        for(int i = 0 ; i < s.length();i++)
        {
            T[2*i+1]='#';
            T[2*i+2]=s.charAt(i);
            
        }
	T[s.length()*2+1]='#';
        
        //T is ready now
        int C=0, R=0;
        int[] P = new int[T.length];
        
        for(int i =1;i<T.length-1;i++)
        {
            int mirr= (2*C)-i;
            //check if pseudo center i is within R
            if(i<R)
                P[i]= Math.min(P[mirr],R-i);
            
            //expand to check and test for palindromes
            while(T[i+P[i]+1] == T[i-P[i]-1])
                P[i]++;
            
            //check to see is Right boundary is violated by P of i
            if((i+P[i])>R)
            {
                C=i;
                R=i+P[i];
            }
            
           
        }
            
		int length = 0;    
	        int center = 0;    
	        for (int i = 1; i < P.length-1; i++) {
	            if (P[i] > length) {
	                length = P[i];
	                center = i;
	            }
	        }
            
            return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
        
        
    }
}
