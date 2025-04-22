
import java.util.Collections;
import java.util.ArrayList;
class inbuilt{

    public static void main(String[] args) {
        ArrayList<Integer> l=new ArrayList<>();
        l.add(9);
        l.add(20);
        l.add(45);
        l.add(4);
        l.add(22);
        l.add(44);
        Collections.sort(l);
        System.out.println(l);
    }
}