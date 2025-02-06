
import java.util.Scanner;

public class getithbit{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int n =sc.nextInt();
         int i=sc.nextInt();
         int bitMask=(1<<i);
         if((n&bitMask)!=0){
             System.out.println("ith bit is 1");
         }else{
            System.out.println("ith bit is 0");
         }
        
    }
}