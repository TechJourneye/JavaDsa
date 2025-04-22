import java.util.Stack;

class pushAtbottom{
      public static void pushatBottom(Stack<Integer> st,int data){
        if(st.isEmpty()){
            st.add(data);
            return;
        }
        int pop=st.pop();
        pushatBottom(st, 4);
        st.add(pop);
      }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
         st.add(1);
         st.add(2);
         st.add(3);
        pushatBottom(st, 4);
        System.out.println(st);
    }
}