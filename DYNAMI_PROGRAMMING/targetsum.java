public class targetsum{
      public static boolean targetSumsubset(int arr[],int sum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
              int v=arr[i-1];
              //include
              if(v<=j  &&  dp[i-1][j-v]==true){
                 dp[i][j]=true;
              }//exclude
              else if(dp[i-1][j]==true){
                dp[i][j]=true;
              }
            }
        }
        print(dp);
        return dp[n][sum];
      }
      public static void print(boolean [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
           
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]){
                    System.out.print("T"+" ");
                }else{
                    System.out.print("F"+" ");
                }
                
            }
            System.out.println();  // Move to the next line after each row
        }
    }
    public static void main(String[] args) {
          int arr[]={4,2,7,2,30};
          int sum=5;
           System.out.println(targetSumsubset(arr, sum));
      
    }
}