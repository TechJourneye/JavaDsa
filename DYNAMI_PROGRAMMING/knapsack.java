
import java.util.Arrays;

public class knapsack{

    public static int KnapsackMem(int val[],int wt[],int W,int n,int dp[][]){
       if(W==0||n==0){
        return 0;
       }
       if(dp[n][W]!=-1){
        return dp[n][W];
       }
        if(wt[n-1]<=W){
            //include
            int ans1=val[n-1]+KnapsackMem(val, wt, W-wt[n-1], n-1,dp);
           //Exclude
            int ans2=KnapsackMem(val, wt, W, n-1,dp);
            dp[n][W]= Math.max(ans1,ans2);
            return dp[n][W];
        }else{
            dp[n][W]=KnapsackMem(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }

    public static int knapsackTab(int val[],int wt[],int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int V=val[i-1];
                int w=wt[i-1];
                if(w<=j){
                    int incProfit=V+dp[i-1][j-w];
                    int excProfit=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit, excProfit);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];

    }
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();  // Move to the next line after each row
        }
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={ 2, 5, 1,  3 ,4};
        int W=7;
        int n=wt.length;
        int dp[][]=new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
         System.out.println(knapsackTab(val, wt, W));
         
    }
}