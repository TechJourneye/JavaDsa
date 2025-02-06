public class linkedlistadd{
     public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
     }
     public static Node head;
     public static Node tail;
     public static int size;
     //print linked list
     public void printLL(Node head){
         Node temp=head;
         while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
         }
         System.out.println();
     }
      ///add first in linked list
     public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;
     }
     // add last
     public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;
     }
     // insert at any position
     public void insertatPos(int data,int index ){
         Node newnNode=new Node(data);
         if(index==0){
            addFirst(data);
            size++;
            return;
         }
         Node temp=head;
         
         int i=0;
         while(i<index-1&&temp!=null){
            temp=temp.next;
            i++;
         }
         if(temp==null){
            System.out.print("position out of bounds");
            return;
         }
         newnNode.next=temp.next;
         temp.next=newnNode;
         size++;
     }
     //remove first
     int removeFirst(){
        if(head==null){
            return -1;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
     }
     //remove last
     int removeLast(){
       Node temp=head;
       Node prev=head;
       while (temp.next!=null) { 
           prev=temp;
           temp=temp.next;
       }
       int val=temp.data;
       prev.next=null;
       tail=prev;
       size--;
       return val;
     }
    public static void main(String[] args) {
       linkedlistadd ll=new linkedlistadd();
       ll.addFirst(4);
       ll.addFirst(5);
       ll.addFirst(9);
       ll.addFirst(7);
       ll.addLast(9);
       ll.addLast(900000);
       ll.insertatPos(70,2);
       ll.printLL(head);
       System.out.println(ll.removeLast());
       ll.printLL(head);
    }
}