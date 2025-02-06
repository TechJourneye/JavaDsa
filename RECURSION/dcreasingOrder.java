public class dcreasingOrder{
     
   public static void printNoinDecreasing(int n){
    if(n==0){
        System.out.println();
        return;
    }
    System.out.print(n+" ");
    printNoinDecreasing(n-1);
    
   }

   public static void printNoinIncreasing(int n){
    if(n==0){
        return;
    }
    // System.out.print(n+" ");
    printNoinIncreasing(n-1);
    System.out.print(n+" ");
   }

   public static void main(String[] args) {
    printNoinDecreasing(20);
    // printNoinIncreasing(20);
   }
}