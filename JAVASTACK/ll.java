

public class ll{
 public static class LLStack{
      static class Node {
        int data; Node next;
         public Node(int data) {
           this.data=data;
         }              
      }
      public static Node head;
      boolean isEmpty(){
        return head==null;
      }
      void push(int data){
        Node newnNode=new Node(data);
        if(isEmpty()){
            head=newnNode;
            return;
        }
       newnNode.next=head;
       head=newnNode;
        
      }
      int pop(){
        if(isEmpty()) return -1;
        int val=head.data;
        head=head.next;
        return val;
      }
    }

    public static void main(String[] args) {
         LLStack st=new LLStack();
         st.push(3);
         st.push(4);
         st.push(5);
         st.push(6);
         while(!st.isEmpty()){
            System.out.println(st.pop());
         }
    }
}