
import java.util.ArrayList;

class multidimensional{

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();

        ArrayList<Integer> l1=new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        ArrayList<Integer> l2=new ArrayList<>();
        l2.add(5);
        l2.add(6);
        l2.add(7);
        l2.add(8);
        l2.add(9);
        mainList.add(l1);
        mainList.add(l2);
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> l=mainList.get(i);
            for(int j=0;j<l.size();j++){
                 System.out.print(l.get(j)+" ");
            }
            System.out.println();
        }
    }
}