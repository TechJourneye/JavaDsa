
import java.util.*;
public class hashset{

public static void main(String[] args) {
   TreeSet<String> hs=new TreeSet<>();

    hs.add("Delhi");
    hs.add("Mumbai");
    hs.add("Kolkata");
    hs.add("Chennai");
     
    // Iterator it=hs.iterator();
    // while(it.hasNext()){
    //     System.out.println(it.next());
    // }
     
    for (String city : hs) {
        System.out.println(city);
    }
}
}