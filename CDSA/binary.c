#include<stdio.h>
#include<stdlib.h>

int binary(int arr[],int st,int end,int key){

    while(st<=end){
        int mid=st+(end-st)/2;
        if(arr[mid]==key){
            return mid;
        } else if(arr[mid]<key){
            st=mid+1; //right part 
        }else{
            end=mid-1; //left part
        }
    }
    return -1;
}
int main(){
 int arr[]={2,5,7,9,30,49};
 int size=sizeof(arr)/sizeof(arr[0]);
 int key=49;
 int found=binary(arr,0,size-1,key);
 if(found==-1){
    printf("key not found");
 }else{
    printf(" key found at %d",found);
 }
}