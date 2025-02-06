public class searchinSortedMatrix{
   
    public static void searchinSortedMatrix(int arr[][],int key){
        int i=0;
        int j=arr[0].length-1;
        while(i<=arr.length-1&&j>=0){
            int cellVal=arr[i][j];
            if(key==cellVal){
                System.out.println("key found at "+i+" "+j);
                return;
            }else if(key<cellVal){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("key not found");
    }

    public static void main(String[] args) {
        int arr1[][]={{10,20,30,40},
                      {15,25,35,45},
                      {27,29,37,48,},
                      {32,33,39,50}};
       searchinSortedMatrix(arr1, 33);
    }
}