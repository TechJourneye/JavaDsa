
import java.util.HashMap;
import java.util.Set;

public class hashmap{

    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();

        hm.put("India", 100);
        hm.put("china", 150);
        hm.put("Nepal", 30);
        hm.put("US", 60);
        
        Set<String> keys=hm.keySet();
        System.out.println(keys);
        
        for (String k: keys) {
            System.out.println("Keys->"+k+","+"value->"+hm.get(k));
        }
    }
}