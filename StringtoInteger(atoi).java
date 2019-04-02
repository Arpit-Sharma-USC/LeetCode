

class Solution {
 public int myAtoi(String str) {
  
     str=str.trim();
     int length = str.length();
    
     if(str=="null"|| length<1)
         return 0;
          
     int i=0;

     int flag=1;
     
     if(str.charAt(0)=='+')
         i++;
     else if(str.charAt(0)=='-')
     {
        flag=-1;
         i++;
     }
     else if(str.charAt(0)!='+' && str.charAt(0)!='-' && (str.charAt(0)<'0' || str.charAt(0)>'9'))
         return 0;
     
     double res=0;
     
     while(i<length && str.charAt(i)>='0' && str.charAt(i)<='9')
    {
         res=res*10 + (str.charAt(i)-'0');
         i++;      
        
     }
     
     if(flag*res<0)
         res = -res;
     
     if(res>Integer.MAX_VALUE)
         return Integer.MAX_VALUE;
    
     if(res<Integer.MIN_VALUE)
         return Integer.MIN_VALUE;
     
     return (int)res;
     
 }
    
}
