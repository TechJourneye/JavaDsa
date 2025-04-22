public class gridwasy{

    public static int gridWays(int i,int j,int row,int col){

        if(i==row-1&&j==col-1) return 1;

        if(i==row||j==col){
           return 0;
        }
      

     return gridWays(i,j+1,row, col)+ gridWays(i+1,j ,row, col);
    }
 public static void main(String[] args) {
    int n=3;
    int m=3;
    int grid[][]=new int[n][m];
    System.out.println(gridWays( 0, 0,7,15));
 }
}