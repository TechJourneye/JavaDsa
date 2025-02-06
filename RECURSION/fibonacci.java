public class fibonacci{

    int calFibo(int n){

       if(n==0) return 0;
       if(n==1) return 1;
       return calFibo(n-1)+calFibo(n-2);
       
        
    }
    public static void main(String[] args) {
        fibonacci f=new fibonacci();
        System.out.println(f.calFibo(23));
        System.out.println(f.calFibo(24));
        System.out.println(f.calFibo(25));
        System.out.println(f.calFibo(26));
        System.out.println(f.calFibo(27));
        System.out.println(f.calFibo(28));
    }
}