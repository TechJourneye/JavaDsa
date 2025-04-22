
import java.util.Arrays;

public class climbingStairs{

    public static int WaysMem(int n ,int[] dp){
        if(n==0) {
            return 1;
        }
        if(n<0) return 0;
        
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=WaysMem(n-1,dp)+WaysMem(n-2,dp)+WaysMem(n-3, dp);
        return dp[n];
    }

    public static int waysTab(int n){
        int dp[]=new int[n+1];
            dp[0]=1;
        for(int i=1;i<dp.length;i++){
        if(i==1){
            dp[i]=1;
        }else{
            dp[i]=dp[i-1]+dp[i-2];
        }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
         int[] dp=new int[n+1];
         Arrays.fill(dp, -1);
        System.out.println(waysTab(n));
    }
}