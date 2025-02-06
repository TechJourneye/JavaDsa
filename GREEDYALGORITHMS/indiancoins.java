
import java.util.Arrays;
import java.util.Comparator;

class indiancoins{
    public static void main(String[] args) {
         int coins[]={1,2,5,10,20,50,100,500,2000};
         int sortArr[][]=new int[coins.length][coins.length];

         for(int i=0;i<coins.length;i++){
            sortArr[i][0]=i;
            sortArr[i][1]=coins[i];
         }
         Arrays.sort(sortArr,Comparator.comparingDouble(o->o[1]));
         int chutta=0;
         int val=1059;
    
            for(int i=coins.length-1;i>=0;i--){
                
                if(val>=sortArr[i][1]){
                    while(val>=sortArr[i][1]){
                    chutta++;
                    // System.out.println(val);
                    val-=sortArr[i][1];
                    }
                } 

             }
          System.out.println(chutta);
    }
}