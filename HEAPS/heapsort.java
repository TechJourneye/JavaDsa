

class heapsort{

    public static void heapfy(int arr[],int i,int size){
        int leftChild=2*i+1;
        int rightChild=2*i+2;
        int maxIdx=i;
        if(leftChild<size&&arr[maxIdx]<arr[leftChild]){
            maxIdx=leftChild;
        }
        if(rightChild<size&&arr[maxIdx]<arr[rightChild]){
            maxIdx=rightChild;
        }
        if(i!=maxIdx){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapfy(arr, maxIdx, size);
        }
    }
public static void heapSort(int arr[]){
int n=arr.length;
//step 1--> create a maxheap
for(int i=n/2;i>=0;i--){
    heapfy(arr,i,n);
}
for(int i=n-1;i>=0;i--){
    int temp=arr[0];
    arr[0]=arr[i];
    arr[i]=temp;
    heapfy(arr,0,i);
}
}

public static void main(String[] args) {
    int arr[]={3,1,2,4,5};
    heapSort(arr);
    for(int i=0;i<arr.length;i++){
     System.out.print(arr[i]+" ");
    }
}






























//     public static void heapify(int arr[],int i,int size){
//         int left=2*i+1;
//         int right=2*i+2;
//         int maxIdx=i;
//         if(left<size&&arr[left]>arr[maxIdx]){
//             maxIdx=left;
//         }
//         if(right<size&&arr[right]>arr[maxIdx]){
//             maxIdx=right;
//         }
//         if(maxIdx!=i){
//             int temp=arr[i];
//             arr[i]=arr[maxIdx];
//             arr[maxIdx]=temp;
//         }
//     }
//     public static void heapSort(int arr[]){   //TC-> O(nlogn)
//         int n=arr.length;
//         // step1--> create maxheap
//         for(int i=n/2;i>=0;i--){
//             heapify(arr,i,n);
//         }
//     /// step2-->push max element at end
//       for(int i=n-1;i>=0;i--){
//         //swap
//         int temp=arr[0];
//         arr[0]=arr[i];
//         arr[i]=temp;
//         heapify(arr,0,i);
//       }
//     }
//     public static void main(String[] args) {
//         int arr[]={1,2,4,5,30,-20,40,100};
//         heapSort(arr);
//         for(int i=0;i<arr.length;i++){
//             System.out.print(arr[i]+" ");
//         }
//     }
 }