
import java.util.ArrayList;

public class pairforroated{
    public static boolean pairSum(ArrayList<Integer> list,int target){
        int bp=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp=bp+1;
        int rp=bp;
        int n=list.size();
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target) return true;
            if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%n;
            } else{
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> l=new ArrayList<>();
        l.add(11);
        l.add(15);
        l.add(1);
        l.add(4);
        l.add(5);
        l.add(6);
    System.out.println(pairSum(l, 17));
    }
}