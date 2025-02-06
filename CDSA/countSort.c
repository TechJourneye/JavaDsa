// #include <stdio.h>
// #include<stdlib.h>

// void printArr(int arr[],int size){
//   for(int i=0;i<size;i++){
//     printf("%d->",arr[i]);
//   }
// }
// void countSort(int arr[],int size){
//     int max=0;
//     for(int i=0;i<size;i++){
//         if(arr[i]>max){
//             max=arr[i];
//         }
//     }

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
//     free(frequency);
// }
// int main(){
//     int arr[]={1,2,5,6,3,5,2,3};
//     int size=sizeof(arr)/sizeof(arr[0]);
//     countSort(arr,size);
//     printArr(arr,size);
// }

// #include<stdio.h>
// #include<stdlib.h>

// void printArr(int arr[],int size){
//   for(int i=0;i<size;i++){
//     printf("%d->",arr[i]);
//   }
// }

// void countSort(int arr[],int size){
//     int  max=-1;
//     for(int i=0;i<size;i++){
//         if(arr[i]>max){
//             max=arr[i];
//         }
//     }
//     int *frequency=(int*)calloc(max+1,sizeof(int));
//     if(!frequency){
//         printf("memory allocation failed");
//     }
//     for(int i=0;i<size;i++){
//         frequency[arr[i]]++;
//     }
//     //sorting
//     int j=0;
//     for(int i=0;i<max;i++){
//         while(frequency[i]>0){
//             arr[j]=i;
//             frequency[i]--;
//             j++;
//         }
//     }
//     free(frequency);
// }
// int main(){
//     int arr[]={2,1,2,4,6,7,8,2,4,5,9,0,2,1};
//     int size=sizeof(arr)/sizeof(arr[0]);
//     countSort(arr,size);
//     printArr(arr,size);
// }



#include <stdio.h>

// Function to swap two elements
void swap(int *xp, int *yp) {
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

// Function to perform selection sort
void selectionSort(int arr[], int size) {
    int i, j, min_idx;

    // Traverse through the entire array
    for (i = 0; i < size - 1; i++) {
        // Find the minimum element in the unsorted part of the array
        min_idx = i;
        for (j = i + 1; j < size; j++) {
            if (arr[j] < arr[min_idx]) {
                min_idx = j;
            }
        }

        // Swap the found minimum element with the first unsorted element
        swap(&arr[min_idx], &arr[i]);
    }
}

// Function to print the array
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}
// insertion sort
void insertionSort(int arr[],int size){
  for(int i=1;i<size;i++){
    int curr=arr[i];
    int prev=i-1;
    while(prev>=0&&arr[prev]>curr){
        arr[prev+1]=arr[prev];
        prev--;
    }
    arr[prev+1]=curr;
  }
}
int main() {
    int arr[] = {64, 25, 12, 22, 11};
    int size = sizeof(arr) / sizeof(arr[0]);

    // Perform selection sort
    insertionSort(arr, size);

    // Print the sorted array
    printf("Sorted array: \n");
    printArray(arr, size);

    return 0;
}
