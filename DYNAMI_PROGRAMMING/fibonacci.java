public class fibonacci{

public static int  fibMemoization(int n,int[] f){

    if(n==0||n==1){
        return n;
    }

    if(f[n]!=0){
        return f[n];
    }

    f[n]= fibMemoization(n-1, f)+fibMemoization(n-2, f);
    return f[n];
}

public  static int FibTabulation(int n){
    int dp[]=new int[n+1];
     dp[0] =0;
     dp[1]=1;
    for(int i=2;i<dp.length;i++){
       dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];
}
//normal
public static int calFibo(int n){

    if(n==0) return 0;
    if(n==1) return 1;
    return calFibo(n-1)+calFibo(n-2);
    
     
 }
    public static void main(String[] args) {
        int n=47;
        int dp[]=new int[n+1];
        System.out.println(fibMemoization(n, dp));
       
    }
}

//0,1,1,2,3,5,8