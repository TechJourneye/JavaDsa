
import java.util.ArrayList;

public class operationsonAl{

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> l2=new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(8);
        list.add(9);
        list.set(2, 10);
        list.add(0,20);
        //iterate on a arrayList
      for(int i=0;i<list.size();i++){
        System.out.print(list.get(i)+" ");
      }
      System.out.println();
      //iterate in reverse
      for(int i=list.size()-1;i>=0;i--){
        System.out.print(list.get(i));
      }
    }
}