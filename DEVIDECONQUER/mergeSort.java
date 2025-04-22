
public class mergeSort {
    

    
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
     System.out.print(arr[i]+" ");
        }
    }

   public static void mergesort(int arr[],int si,int ei){
  
    if(si>=ei) return;
  // Calculate Mid
    int mid= si+(ei-si)/2;
//    call for left part
    mergesort(arr, si, mid);
    // call for right part
    mergesort(arr, mid+1, ei);
    // Merge the SubArray Backbone of merge sort
    merge(arr, si, mid, ei);
   
   }
   public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(k=0,i=si;k<temp.length;i++,k++,si++){
           arr[si]=temp[k];
        }
   }
    public static void main(String[] args) {
        int arr[]={2,0,6,7,8,40,20,30,50,80,};
        mergesort(arr, 0,arr.length-1);
        printArr(arr);
    }
}
