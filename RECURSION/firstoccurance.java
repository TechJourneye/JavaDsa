public class firstoccurance{

    public static int firstoccu(int arr[],int n,int key){
        //base case
         if(n==arr.length) return -1;
           //working method
         if(arr[n]==key) return n;
      // recursive call
         return firstoccu(arr, n+1, key);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,50,6,7,8,9,90};
        System.out.println(firstoccu(arr, 0, 90));
    }
    
}