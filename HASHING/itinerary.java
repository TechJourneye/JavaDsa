
import java.util.HashMap;

public class itinerary{

    public static String getStart(HashMap<String,String> map){
        HashMap<String,String> revmap=new HashMap<>();

        for(String key: map.keySet()){
            revmap.put(map.get(key),key);
        }
        for(String key:map.keySet()){
            if(!revmap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {//////TC----->O(n)
        HashMap<String,String> map=new HashMap<>();
        map.put("chennai", "bengaluru");
        map.put("munbai", "delhi");
        map.put("goa", "chennai");
        map.put("delhi", "goa");
        String start=getStart(map);
  
        System.out.print(start);
        for (String string : map.keySet()) {
            System.out.print("->"+map.get(start));
            start=map.get(start);
        }
        
    }
}