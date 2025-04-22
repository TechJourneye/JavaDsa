import java.util.ArrayList;

public class pairsum{

    public static boolean pairSum(ArrayList<Integer> list,int target){
        // brute force  O(n^2)

        //  for(int i=0;i<list.size();i++){
        //     for(int j=i+1;j<list.size();j++){
        //         if(list.get(i)+list.get(j)==target) return true;
        //     }
        //  }
        //  return false;

        // linear O(n)
        int lp=0;
        int rp=list.size()-1;
        while(lp<rp){
            if(list.get(rp)+list.get(lp)==target) return true;
            if(list.get(rp)+list.get(lp)>target)  rp--;
            if(list.get(rp)+list.get(lp)<target) lp++;
            
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
    System.out.println(pairSum(l, 5));
    }
}