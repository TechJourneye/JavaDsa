
import java.util.Arrays;
import java.util.Comparator;

class   maxlengthchainofpairs{
             public static void main(String[] args) {
                
             int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

             Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));

             int maxchainLength=1;
             int parilast2ndNo=pairs[0][1];
            
             for(int i=1;i<pairs.length;i++){
                if(pairs[i][0]>parilast2ndNo){
                    maxchainLength++;
                    parilast2ndNo=pairs[i][1];
                }
             }
            System.out.println(maxchainLength);

             }             
    }