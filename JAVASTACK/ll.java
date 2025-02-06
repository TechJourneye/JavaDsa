

public class ll{
 public static class LLStack{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
        public static Node head=null;
        static int size=0;
        //is empty
        boolean isEmpty(){
            return head==null;
        }
        // push
        void push(int data){
            Node newnode=new Node(data);
            if(head==null){
                head=newnode;
                size++;
                return;
            }
            newnode.next=head;
            head=newnode;
            // return head.data;
            size++;
        }
        // int pop
        int pop(){
            if(head==null){
                System.out.println("st is empty");
                return -1;
            }
            int data=head.data;
            head=head.next;
            size--;
            return data;
        }

        int peek(){
            if(head==null){
                System.out.println("st is empty");
                return -1;
            }
            return head.data;
        }
     void displayrev(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
     }

     int size(){
        return size;
     }
    
      void displayrec(Node h){
        if(h==null){
            return;
        }
        displayrec(h.next);
        System.out.print(h.data+" ");
      }

      void display(){
       displayrec(head);
       System.out.println();
      }
    }

    public static void main(String[] args) {
         LLStack st=new LLStack();
          st.push(3);
          st.push(7);
          st.push(9);
          st.push(39);
          st.push(70);
          st.push(90);
          System.out.println(st.peek());
          st.display();
          st.pop();
          st.display();
          System.out.println(st.size());
          st.pop();
          st.display();
          st.pop();
          st.display();
          st.pop();
          st.display();
          st.pop();
          st.display();
          st.pop();
          st.display();
          st.pop();
          st.display();
    }
}