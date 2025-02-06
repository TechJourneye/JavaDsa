
import java.util.Scanner;

public class array{

    public static void main(String[] args) {
        int arr[]=new int[4];
         Scanner sc=new Scanner(System.in);
         for(int i=0;i<arr.length;i++){
            System.out.println(".(enter the data)");
            arr[i]=sc.nextInt();
         }
         for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
         }
    }
}