import java.util.Stack;

class nextGraterElement{
   
    public static void main(String[] args) {
        // Brute force approach o(n2)
         int arr[]={1,3,2,1,8,6,3,4};
         int res[]=new int[arr.length];
         Stack<Integer> st=new Stack<>();
         st.push(4);
         res[arr.length-1]=-1;
         for(int i=arr.length-2;i>=0;i--){
              while(!st.isEmpty()&&st.peek()<arr[i]){
                st.pop();
              }

              if(st.isEmpty()) res[i]=-1;
              else{
                res[i]=st.peek();
              }
                st.push(arr[i]);
              
         }

         for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
         }
         System.out.println();
         for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
         }
    }
}