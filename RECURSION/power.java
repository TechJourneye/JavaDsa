public class power{
public static  int power(int x,int n){
    if(n==0){
        return 1;
    }
     
    return x*power(x, n-1);
}

public static  int powerOptimized(int x,int n){
    if(n==0){
        return 1;
    }
     int halfPower=powerOptimized(x, n/2);
     int halfPowerSq=halfPower*halfPower;

     if(n%2!=0){
        halfPowerSq=x*halfPowerSq;
     }
    return halfPowerSq;
}

    public static void main(String[] args) {
        System.out.println(powerOptimized(2, 30));
    }
}