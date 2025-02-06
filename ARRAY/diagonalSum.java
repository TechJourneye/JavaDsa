
public class diagonalSum{

    public static void diagonalSum(int arr[][]){
         //Bruate force O(n^2)
        int sum=0;
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         if(i==j){
        //             sum+=arr[i][j];
        //         }else if(i+j==arr.length-1){
        //             sum+=arr[i][j];
        //         }
        //     }
        // } 
        // System.out.println(sum);

        ////--------->>>>>>>>>>>>>>>>>>>>
        /// O(n)---Linear time complexity
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
            if(i!=arr.length-1-i){
                sum+=arr[i][arr.length-1-i];
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int arr[][]=new int[4][4];
        //  Scanner sc=new Scanner(System.in);
        //  for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         System.out.println("enter the data");
        //         arr[i][j]=sc.nextInt();
        //     }
        //  }
         int arr1[][]={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12,},
                        {13,14,15,16}};
       diagonalSum(arr1);
    }
}