public class factorial{
public static int calFact(int n){
    if(n==1){
        return 1;
    }

    return n*calFact(n-1);
}

    public static void main(String[] args) {
        System.out.println(calFact(9));
    }
}