public class Rodcutting{

    public static int rodCutting(int[] Length,int[] price,int rodLength){
        int n=Length.length;
        int[][] dp=new int[n+1][rodLength+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<rodLength+1;j++){
                if(Length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-Length[i-1]], dp[i-1][j]);
                }else{
                    //invalid
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
          return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[] Length={1,2,3,4,5,6,7,8};
        int[] price={1,5,8,9,10,17,17,20};
        int rodLength=8;
        System.out.println(rodCutting(Length,price,rodLength));
    }
}