public class selectionSort {
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
     System.out.print(arr[i]+" ");
        }
    }

    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int min_idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min_idx]>arr[j]){
                    min_idx=j;
                }
            }
            int temp=arr[min_idx];
            arr[min_idx]=arr[i];
            arr[i]=temp;
        }
    }
    public static void main(String[] args) {
        int arr[]={2,0,6,7,8,};
        selectionSort(arr);
        printArr(arr);
    }
}
