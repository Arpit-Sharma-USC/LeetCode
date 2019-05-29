import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class MyGroupRegex {
 
    private static Pattern ptn = Pattern.compile("((?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?\\.){3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)))");
    //Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");

    public static List<String> captureValues(String[] arr){
        String largeText = Arrays.toString(arr);
        System.out.println(largeText);
        
        
        
        Matcher mtch = ptn.matcher(largeText);
        List<String> ips = new ArrayList<String>();
        while(mtch.find()){
            ips.add(mtch.group());
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(String eachIp: ips)
        {
            if(map.containsKey(eachIp))
                map.put(eachIp,map.get(eachIp)+1);
            else
                map.put(eachIp,1);
        }
        int max= Integer.MIN_VALUE;
       for(Entry<String,Integer> entry:map.entrySet())
       {
           if(entry.getValue()>=max)
            {
                max=entry.getValue();
                
            }
       }
       //have highest count here 
      // System.out.println(max);

       List<String> answer = new ArrayList<>();
      for(Entry<String,Integer> entry:map.entrySet())
       {
           if(entry.getValue()==max)
            {
                answer.add(entry.getKey());
                
            }
       }
        return answer;
    }
     
    public static void main(String a[]){
        String [] str = {"Hi my machine IP is 10.20.30.40 and i would like to access port 80 from the host 23.12.56.34, which internally connects to 3.90.23.65. Please process the request", 
        "Hi my machine IP is 10.20.30.40 and i would like to access port 80 from the host 23.12.56.34",
        "host 23.12.56.34",
        "host 23.12.56.34 is ",
        "host is useless at 23.12.56.34",
            "10.20.30.40 is actually not  but 10.20.30.50. Please 10.20.30.40fix10.20.30.40"
        }; 
        System.out.println(captureValues(str));

    }
}
