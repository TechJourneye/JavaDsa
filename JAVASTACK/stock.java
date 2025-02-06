
import java.util.Stack;

class stock{
public static void stock_pan(int arr[],int span[]){
    Stack<Integer> st=new Stack<>();
    span[0]=1;
    st.push(0);
    for(int i=1;i<arr.length;i++){
        int currEle=arr[i];
        while(!st.isEmpty()&&currEle>=arr[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()) {
            span[i]=i+1;
        }   
        else{
            int pervious=st.peek();
            span[i]=i-pervious;
        }
        st.push(i);
    }
}

    public static void main(String[] args) {
        int arr[]={100,80,60,70,60,85,100};
        int span[]=new int[arr.length];
        stock_pan(arr,span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+" ");
        }
    }
}