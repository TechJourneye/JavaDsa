class countsort{

    public static void countSort(int arr[]){
      int max=Integer.MIN_VALUE;
      for(int i=0;i<arr.length;i++){
        max=Math.max(arr[i], max);
      }
      int[] count=new int[max+1];

      for(int i=0;i<arr.length;i++){
        count[arr[i]]++;
      }
      //sortint 
      int j=0;
     for(int i=0;i<count.length;i++){
      while(count[i]>0){
        arr[j]=i;
        count[i]--;
        j++;
      }
     }
    }

    // bubble sort
    public static void bubbleSort(int arr[]){

        for(int turn=0;turn<arr.length-1;turn++){
            for(int j=0;j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                }
            }
        }
    }
    // public static void printArr(int arr[]) {
    //      for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" ");
    //      }
    // }
    // public static void main(String[] args) {
    //    int arr[] ={0,0,7};
    //    countSort(arr);
    //    printArr(arr);
    // }


    public static void quickSort(int arr[],int si,int ei){
       
        if(si>=ei){
            return;
        }
        int Pidx=partition(arr,si,ei);
        quickSort(arr, si, Pidx-1);
        quickSort(arr, Pidx+1, ei);
    }
    public static int partition(int arr[],int si,int ei){
         int pivot=arr[ei];
         int i=si-1;
         for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[i]=arr[j];
                arr[i]=temp;
            }
         }
         i++;
         int temp=pivot;
         arr[ei]=arr[i];
         arr[i]=temp;
         return i;
    }


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
          bubbleSort(arr);
          printArr(arr);
  
      }
  }
