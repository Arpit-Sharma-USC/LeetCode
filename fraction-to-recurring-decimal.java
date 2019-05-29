class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        //take care of num 0 
        if(numerator==0)
            return "0";
        
        StringBuilder fraction = new StringBuilder();
        
        //take care of -ve sign
        if(numerator<0 ^ denominator <0)
            fraction.append("-");
        
        //take care of overflow 
        long dividend = Math.abs((long)(numerator));
        long divisor = Math.abs((long)(denominator));
        
        fraction.append(String.valueOf(dividend/divisor));
        long rem=dividend % divisor;
        
        //whole results     
        if(rem == 0)
            return fraction.toString();
        fraction.append(".");
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        while(rem!=0)
        {
        
            
            if(map.containsKey(rem))
            {
                fraction.insert(map.get(rem),"(");
                fraction.append(")");
                break;
            }
            map.put(rem,fraction.length());
            rem*=10;
            fraction.append(String.valueOf(rem/divisor));
            rem%=divisor;
            
            
        }
        return fraction.toString();
    }
}
