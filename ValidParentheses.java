class Solution {
    private HashMap<Character,Character> myMap;
    public Solution()
    {
        this.myMap= new HashMap<Character,Character>();
        this.myMap.put(')','(');
        this.myMap.put('}','{');
        this.myMap.put(']','[');
    }
    public boolean isValid(String s) {
       Stack<Character> stack=new Stack<Character>();
        //int count=0;
        for(int i =0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(this.myMap.containsKey(ch))
            {
             //closing bracket or oter char found so pop or return respectively
                char topE = stack.empty()?'#':stack.pop();
                if(topE!=this.myMap.get(ch))
                    return false;
              //  count++;
            }
            else
            {//opening bracket found so push
                stack.push(ch);
            }
        }
      // System.out.println(count);
        return stack.isEmpty();
    }
}
