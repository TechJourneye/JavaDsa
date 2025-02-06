public class sorted{

    boolean sort(int arr[],int n){
        if(n+1==arr.length){
            return true;
        }

        if(arr[n]>arr[n+1]){
            return false;
        }
        
        return sort(arr, n+1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,50,6,7,8,9,90};
        sorted s1=new sorted();

        System.out.println(s1.sort(arr, 0));
    }
}