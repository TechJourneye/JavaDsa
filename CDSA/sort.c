#include <stdio.h>
#include<stdlib.h>

void printArr(int arr[],int size){
  for(int i=0;i<size;i++){
    printf("%d->",arr[i]);
  }
}
void heapfy(int arr[],int i,int size){
 int left=2*i+1;
 int right =2*i+2;
 int maxidx=i;
 if(left<size&&arr[maxidx]<arr[left]){
    maxidx=left;
 }
 if(right<size&&arr[maxidx]<arr[right]){
    maxidx=right;
 }
 if(maxidx!=i){
    int temp=arr[i];
    arr[i]=arr[maxidx];
    arr[maxidx]=temp;
    heapfy(arr,maxidx,size);
 }
}
// heap sort
void heapSort(int arr[],int size){
    for(int i=size/2;i>=0;i--){
         heapfy(arr,i,size);
    }
    //swapping
    for(int i=size-1;i>=0;i--){
        int temp=arr[0];
        arr[0]=arr[i];
        arr[i]=temp;
        heapfy(arr,0,i);
    }
}
// void countSort(int arr[],int size){
//     int max=0;
//     for(int i=0;i<size;i++){
//         if(arr[i]>max){
//             max=arr[i];
//         }
//     }
// // int frequency[max+1];
//      int *frequency = (int *)calloc(max + 1, sizeof(int));
//     if (!frequency) {
//         printf("Memory allocation failed.\n");
//         return;
//     }

//     for(int i=0;i<size;i++){
//         frequency[arr[i]]++;
//     }
//     //sorting
//     int j=0;
//     for(int i=0;i<=max;i++){
//         while(frequency[i]>0){
//             arr[j]=i;
//             j++;
//             frequency[i]--;
//         }
//     }
// }

int main(){
   int arr[]={1,4,2,0,1,4,3,7};
   int size=sizeof(arr)/sizeof(arr[0]);
   heapSort(arr,size);
   printArr(arr,size);
    return 0;
}