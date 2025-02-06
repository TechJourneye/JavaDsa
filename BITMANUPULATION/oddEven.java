
import java.util.Scanner;

public class oddEven{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int bitMask=1;
        if((n&bitMask)==0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
}