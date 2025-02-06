class sortedRotated{

   public static int searchinRoated(int arr[],int si,int ei,int tar){
    if(si>ei){
        return -1;
    }
    int mid=si+(ei-si)/2;

    if(arr[mid]==tar){
        return mid;
    }
    if(arr[mid]>=arr[si]){//  tar on line 1
        if(arr[si]<=tar&&tar<=arr[mid]){//Left on line 1
           return searchinRoated(arr, si, mid-1, tar);
        }else{
            return searchinRoated(arr, mid+1, ei, tar);//right on line 1
        }

    }
    else{
        //target on line 2
        if( arr[mid]<=tar&&tar<=arr[ei]){//target on line 2
            return searchinRoated(arr, mid+1, ei, tar);
        }else{
            return searchinRoated(arr, si, mid-1, tar);
        }
    }
   }
//////////////////////////////////////////////////////////////////////////
   public static int searchinRoated1(int arr[],int si,int ei,int tar){///////
    
    while (si<=ei){
    int mid=si+(ei-si)/2;/////////////////////////////////////
    
    if(arr[mid]==tar){/////////////////////////////////////////////////////
        return mid;///////////////////////////
    }
    if(arr[mid]>=arr[si]){//  tar on line 1
        if(arr[si]<=tar&&tar<=arr[mid]){//Left on line 1
        //    return searchinRoated(arr, si, mid-1, tar);
        ei=mid-1;
        }else{//////////////////////////////
            // return searchinRoated(arr, mid+1, ei, tar);//right on line 1
            si=mid+1;
        }

    }
    else{
        //target on line 2
        if( arr[mid]<=tar&&tar<=arr[ei]){//target on line 2
            // return searchinRoated(arr, mid+1, ei, tar);
            si=mid+1;
        }else{
            // return searchinRoated(arr, si, mid-1, tar);
            ei=mid-1;
        }
    }
}
return -1;
   }

    public static void main(String[] args) {
        int arr[]={4,5,6,0,1,2,3};
        System.out.println(searchinRoated1(arr, 0, arr.length-1, 3));
    }
}