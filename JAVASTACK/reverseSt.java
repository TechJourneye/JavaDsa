import java.util.Stack;

class reverseSt{
    public static void pushatBottom(Stack<Integer> st,int data){
        if(st.isEmpty()){
            st.add(data);
            return;
        }
        int pop=st.pop();
        pushatBottom(st, data);
        st.add(pop);
      }
      public static void reverse(Stack<Integer> st){

        if(st.isEmpty()) return;
        int pop=st.pop();
        reverse(st);
        pushatBottom(st, pop);
      }
    public static void main(String[] args) {
         Stack<Integer> st=new Stack<>();
         st.add(1);
         st.add(2);
         st.add(3);
         System.out.println(st);
      reverse(st);
      System.out.println(st);
    }
}