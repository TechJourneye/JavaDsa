
import java.util.Stack;


class nextGraterElement{
    
  public static void nextGreater(int[] arr,int[] res,Stack<Integer> st){

    for(int i=arr.length-1;i>=0;i--){
      while(!st.isEmpty()&&arr[i]>=arr[st.peek()]){
        st.pop();
      }
      if(st.isEmpty()){
        res[i]=-1;
      }else{
        res[i]=arr[st.peek()];
      }
      st.push(i);
    }
  }
  public static void printArr(int arr[]){
    for(int i=0;i<arr.length;i++){
  System.out.print(arr[i]+" ");
    }
  }
    public static void main(String[] args) {
      int arr[]={1,5,8,1,3,9,1,4};
      int res[]=new int[arr.length];
      Stack<Integer> st=new Stack<>();
     nextGreater(arr, res, st);
    printArr(res);
    //{ 4 question
    //next greater right 
    //next greater left
    //next smallest right
    //next smallest left

  // }
    
    }
}