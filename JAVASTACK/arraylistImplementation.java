 import java.util.*;
class arraylistImplementation{
     public static ArrayList<Integer> list=new ArrayList<>();

     boolean isEmpty(){
        return list.size()==0;
     }
     void push(int data){
         list.add(data);
     }
     int pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }       
        return  list.remove(list.size()-1);
     }
     int peek(){
        return list.get(list.size()-1);
     }
    public static void main(String[] args) {
        arraylistImplementation st=new arraylistImplementation();

        st.push(2);
        st.push(3);
        st.push(4);
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
       
    }
}