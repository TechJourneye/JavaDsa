
import java.util.Arrays;

public class mcm {

public static int mcm1(int arr[], int i, int j) {
if(i == j) {
return 0; //single matrix case
}
int ans = Integer.MAX_VALUE;
for(int k=i; k<=j-1; k++) {
int cost1 = mcm1(arr, i, k); //Ai...Ak => arr[i-1]xarr[k]
int cost2 = mcm1(arr, k+1,j); //Ai+1...Aj => arr[k]xarr[j]
int cost3 = arr[i-1] * arr[k] * arr[j];
int finalCost = cost1 + cost2+ cost3;
   ans = Math.min(ans, finalCost);
   //mincost
  }
return ans; 
}
public static int mcmMem(int arr[], int i, int j,int dp[][]) {
    if(i == j) {
    return 0; //single matrix case
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    int ans = Integer.MAX_VALUE;
    for(int k=i; k<=j-1; k++) {
    int cost1 = mcmMem(arr, i, k,dp); //Ai...Ak => arr[i-1]xarr[k]
    int cost2 = mcmMem(arr, k+1,j,dp); //Ai+1...Aj => arr[k]xarr[j]
    int cost3 = arr[i-1] * arr[k] * arr[j];
    int finalCost = cost1 + cost2+ cost3;
       ans = Math.min(ans, finalCost);
       //mincost
      }
    return dp[i][j]=ans; 
    }
public static void main(String args[]){
      int arr[] = {1, 2, 3, 4, 3}; //n = 5
      int n = arr.length;
       System.out.println(mcm1(arr,  1, n-1));

       int dp[][]=new int[n][n];
       for(int i=0;i<dp.length;i++){
        Arrays.fill(dp[i], -1);
       }
       System.out.println(mcmMem(arr, 1, n-1, dp));
  } 
}