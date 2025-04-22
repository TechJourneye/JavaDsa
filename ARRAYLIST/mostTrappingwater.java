
import java.util.ArrayList;

class mostTrapppingwater{
//brute force

  public static int mostWatercal(ArrayList<Integer> height){
    int maxWater=0;
    //TC=O(n^2)
    for(int i=0;i<height.size();i++){
        for(int j=0;j<height.size();j++){
            int minht=Math.min(height.get(i), height.get(j));
            int width=j-i;
            int cueeWater=minht*width;
            maxWater=Math.max(maxWater, minht*width);
        }
    }
    return maxWater;
  }
//two pointer approach
//TC=O(n)
public static int mostWatercal2(ArrayList<Integer> height){
    int maxWater=0;
    //TC=O(n^2)
     int lp=0;
     int rp=height.size()-1;
     while(lp<rp){
        int ht=Math.min(height.get(rp),height.get(lp));
        int wd=rp-lp;
        int currWater=ht*wd;
        maxWater=Math.max(maxWater, currWater);
        if(height.get(lp)<height.get(rp)){
            lp++;
        }else{
            rp--;
        }
     }
    return maxWater;
  }
    public static void main(String[] args) {
        ArrayList<Integer> height=new ArrayList<>();
        //[1,8,6,2,5,4,8,3,7]
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(mostWatercal2(height));
        for(int i=0;i<7;i++){
            for(int j=i+1;j<5;j++){

                if(j==1){
                    break;
                }
                System.out.print(j+" ");
            }
            // System.out.println(i);
        }
    }
}