
import java.util.Arrays;
import java.util.Comparator;

class fractionalknapsack{

    public static void main(String[] args) {
        int value[]={60,100,120};
        int weight[]={10,20,30};
         int W=50;
        double ratio[][]=new double[weight.length][2];
        //sorting 
        for(int i=0;i<weight.length;i++){
            ratio[i][0]=i;
            ratio[i][1]= value[i]/(double)weight[i]; //Ratio 
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        
        int capacity=W;
        int finalVal=0;   
        for(int i=weight.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){
                finalVal += value[idx];  //include full item
                capacity-=weight[idx];
            }else{
                //include fractional item
                finalVal+=ratio[i][1]*capacity;
                capacity=0;
                break;
            }
        }

        System.out.println(finalVal);

    //     for(int i=0;i<weight.length;i++){
    //         for(int j=0;j<=1;j++){
    //   System.out.print(ratio[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    }
}