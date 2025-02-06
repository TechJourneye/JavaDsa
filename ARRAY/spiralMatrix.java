import java.util.Scanner;

public class spiralMatrix{
  
    public static void spiralMetrix(int arr[][]){
        int startRow=0;
        int endRow=arr.length-1;
        int startColum=0;
        int endColume=arr[0].length-1;
            
           while(startRow<=endRow && startColum<=endColume){
            //  top  
            for(int j=startColum;j<=endColume;j++) {
                 System.out.print(arr[startRow][j]+" ");
            }
            // right
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(arr[i][endRow]+" ");
            }
            // bottom
            for(int j=endColume-1;j>=startColum;j--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(arr[endRow][j]+" ");
            }
            ///left  
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startColum==endColume){
                    break;
                }
                System.out.print(arr[i][startColum]+" ");
            }
            startRow++;
            endRow--;
            startColum++;
            endColume--;
           }

    }
    public static void main(String[] args) {
         int arr[][]=new int[4][4];
         Scanner sc=new Scanner(System.in);
         for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println("enter the data");
                arr[i][j]=sc.nextInt();
            }
         }
       spiralMetrix(arr);
    }
}