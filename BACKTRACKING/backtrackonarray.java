public class backtrackonarray{

public  static void backtrackonArray(int arr[],int i){
    if(i==arr.length){
        return;
    }

    arr[i]=i+1;
    backtrackonArray(arr, i+1);
    arr[i]=arr[i]-2;
}

    public static void main(String[] args) {
       int arr[]=new int[5];
       backtrackonArray(arr, 0);
       for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
       }
    }
}