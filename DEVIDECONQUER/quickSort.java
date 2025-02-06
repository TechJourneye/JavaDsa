public class quickSort{


    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
     System.out.print(arr[i]+" ");
        }
    }

    public static void quickSort(int arr[],int si,int ei){
       
        if(si>=ei){
            return;
        }
        int Pidx=partition(arr,si,ei);
        quickSort(arr, si, Pidx-1);
        quickSort(arr, Pidx+1, ei);
    }
    public static int partition(int arr[],int si,int ei){
         int pivot=arr[si];
         int i=si-1;
         for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
         }
         i++;
        int temp = arr[i];
        arr[i] =pivot;
        arr[si] = temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[]={2,0,6,7,8};
         quickSort(arr,0,arr.length-1);
        // printArr(arr);
        mergeSort.printArr(arr);
    
    }
}