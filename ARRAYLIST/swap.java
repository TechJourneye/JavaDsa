import java.util.ArrayList;

class swap{

public static ArrayList swap(ArrayList<Integer> l,int idx1,int idx2){
   int temp=l.get(idx1);
   l.set(idx1, l.get(idx2));
   l.set(idx2, temp);

    return l;
}

    public static void main(String[] args) {
      ArrayList<Integer> l=new ArrayList<>();
        l.add(9);
        l.add(20);
        l.add(45);
        l.add(4);
        l.add(22);
        l.add(44);   
        System.out.println(swap(l,0,l.size()-1));
    }
}