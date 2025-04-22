
import java.util.Stack;

class stock{

   public static void stockSpan(Stack<Integer> st,int span[],int stocks[]){
        span[0]=1;
        st.push(0);

        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
             while(!st.isEmpty()&&currPrice>stocks[st.peek()]){
                st.pop();
             }
             if(st.isEmpty()){
                span[i]=i+1;
             }else{
                int prevHigh=st.peek();
                span[i]=i-prevHigh;
             }
             st.push(i);
        }
   }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        int stock[]={100,80,60,70,60,85,100};
        int span[]=new int[stock.length];
        stockSpan( st, span, stock);
        for(int i=0;i<span.length;i++){
            System.out.println(span[i]);
        }
       
    }
}