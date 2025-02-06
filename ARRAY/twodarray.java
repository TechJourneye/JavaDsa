
import java.util.Scanner;

public class twodarray{

    public static void found(int arr[][]){
         int max=Integer.MIN_VALUE;
         int min=Integer.MAX_VALUE;
         for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                max=Math.max(max, arr[i][j]);
                min=Math.min(min, arr[i][j]);
            }
         }
      System.out.println("max->"+max+" min->"+min);
    }

    public static void main(String[] args) {
        int arr[][]=new int[3][3];
         Scanner sc=new Scanner(System.in);

         for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println("enter the data");
                arr[i][j]=sc.nextInt();
            }
         }
         
         for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
         }
         found(arr);
    }
}