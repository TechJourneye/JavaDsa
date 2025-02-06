public class LinkedList{
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

  //  public void addFirst(int data){
  //     //step-1 :create new Node
  //     Node newNode= new Node(data);
  //     if(head==null){
  //       head=tail=newNode;
  //       return;
  //     }
  //     //step 2: newNode next =head
  //     newNode.next=head;
  //     //step-3: head will ne newNode
  //     head=newNode;
  //  }

  //  public void addLast(int data){
  //    Node newNode=new Node(data);
  //    if(head==null){
  //      head=tail=newNode;
  //      return;
  //    }
  //    tail.next=newNode;
  //    tail=newNode;
  //  }

  //  public void printLL(){
  //    Node temp=head;
  //    if(head==null){
  //     System.out.print("ll is empty");
  //    }
  //    while (temp!=null) {
  //         System.out.print(temp.data+" ");
  //         temp=temp.next;
  //    }
  //    System.out.println();
  //  }
  // public static void displayll(Node head){
  //     while(head!=null){
  //        System.out.print(head.data+" ");
  //        head=head.next;
  //     }
  // }

  // insert at end 
 void insertatEnd(int val){
    Node temp=new Node(val);
      if(head==null){
        head=tail=temp;
        return;
      }
      tail.next=temp;
      tail=temp;
  }
// displaying ll 
  void display(){
      Node temp=head;
      while(temp!=null){
        System.out.print(temp.data+"->");
        temp=temp.next;
      }
      System.out.println("null");
  }
  //display by recursion
  void displaybyrec(Node head){
     if(head==null){
      return;
     }
     System.out.print(head.data+"->");
     displaybyrec(head.next);
  }
  // size of ll
  int  size(){
     int count =0;
     Node temp=head;
     while(temp!=null){
        count++;
        temp=temp.next;
     }
     return count;
  }
  // insert at top
  void insertatSt(int val){
      Node temp=new Node(val);
      if(head==null){
        head=tail=null;
        return;
      }
      temp.next=head;
      head=temp;
  }
  // insert at index 
  void insertatIdx(int idx,int val){
      Node t=new Node(val);
      Node temp=head;
      if(idx==size()){
        insertatEnd(val);
        return;
      } else if(idx==0){
         insertatSt(val);
         return;
      }
      for (int i=1;i<=idx-1;i++){
          temp=temp.next;
      }
      t.next=temp.next;
      temp.next=t;
  }
  // get element
  int getelementfromIdx(int idx){
     Node temp=head;
     for(int i=1;i<=2;i++){
       temp=temp.next;
     }
     return temp.data;
  } 
// delete fromindex
  void deletefromIdxNo(int idx){
     Node temp=head;
     if(idx==0){
      head=head.next;
      return;
     }
     for (int i=1;i<idx;i++){
      temp=temp.next;
     }
     temp.next=temp.next.next;
     tail=temp;
  }

  // delete element as parameter
  void delElement(int val){//
    Node curr=head;
    Node previ=null;
     while(curr!=null&&curr.data!=val){
        previ=curr;
        curr= curr.next;
     }
     if (head.data == val) {
      head = head.next;  
      return;
  }

     if (curr == null) {
      System.out.println("Element not found in the list.");
      return;
  }
      previ.next=curr.next;
  }

  public void delete(int data) {
    // If list is empty
    if (head == null) {
        System.out.println("List is empty. Nothing to delete.");
        return;
    }

    // If head needs to be removed
    if (head.data == data) {
        head = head.next;  
        return;
    }

    // Search for the node to delete
    Node current = head;
    Node previous = null;

    while (current != null && current.data != data) {
        previous = current;
        current = current.next;
    }

    // If the data is not found
    if (current == null) {
        System.out.println("Element not found in the list.");
        return;
    }

    // Unlink the node to delete it
    previous.next = current.next;
}

//linkedlist 2nd part
// getting nth node 
Node nthNode(Node head,int n){
     int m=size();
     m=m-n+1;
     Node temp=head;
     for(int i=1;i<m;i++){
        temp=temp.next;
     }
     return temp;
}
// better approach nth node
 Node nthNode2(Node head,int n){
    Node slow=head;
    Node fast=head;
    for(int i=1;i<=n;i++){
      fast=fast.next;
    }
    while(fast!=null){
      fast=fast.next;
      slow=slow.next;
    }
    return slow;
 }
 
 //deleting nth node from last
  Node deletenthNode(int n){
  Node slow=head;
  Node fast=head;
  for(int i=1;i<=n;i++){
    fast=fast.next;
  }
  if(fast==null){
    head=head.next;
    return head;
  }
  while(fast.next!=null){
    fast=fast.next;
    slow=slow.next;
  }
  slow.next=slow.next.next;
  return head;
}
// get right middle element for node
 Node getRightMiddleElement(){
   Node slow=head;
   Node fast=head;
   while(fast!=null&&fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
   }
   return slow;
 }
 //get left middle element
 Node getLeftMiddleElement(){
  Node slow=head;
  Node fast=head;
  while(fast.next.next!=null){
      slow=slow.next;
      fast=fast.next.next;
  }
  return slow;
 }
 //delete the middle of a linked list
 void deleteMiddleofLl(){
         // Edge cases: empty list or single node
         if (head == null || head.next == null) {
          head = null;
          return ;
      }

      Node slow = head;
      Node fast = head;
      Node prev = null;

      // Move fast by two steps and slow by one step
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          prev = slow;
          slow = slow.next;
      }

      // Slow is now at the middle, prev is just before it
      if (prev != null) {
          prev.next = slow.next; // Remove middle node
      }
  
 }
 // detect cycle in a linked list
 boolean detectcycle(){
    Node fast=head;
    Node slow=head;
    while(fast!=null&&fast.next!=null){
       slow=slow.next;
       fast=fast.next.next;
       if(fast==slow){
        return  true;
       }
    }
    return false;
 }
 //return the Node where in the cycle tails points to the node 
Node getCycleNode(){
  Node slow=head;
  Node fast=head;
  while(fast!=null){
     slow=slow.next;
     fast=fast.next.next;
     if(fast==slow) break;
  }
  Node temp=head;
  while(temp!=slow ){
     temp=temp.next;
     slow=slow.next;
  }
  return slow;
}
 //reverse a linked list by iterative process
 Node reversellbyIterativePrecess(Node head){
   Node prev=null;
   Node curr=tail=head;
   Node next;
   while(curr!=null){
     next=curr.next;
     curr.next=prev;
     prev=curr;
     curr=next;
   }
    head=prev;
    return head;
 }
// reverse a linked list by recursion method
Node reverseByRecursion(Node head){
   if( head.next==null){
      return head;
   }
   Node newhead=reverseByRecursion(head.next);
   head.next.next=head;
   head.next=null;
   return  newhead;
}
//check if a linked list is palindrome or not 
boolean checkPalindrome() {
    Node mid=getRightMiddleElement();
    Node right=reversellbyIterativePrecess(mid);
    Node left=head;
    while(right!=null){
      if(right.data!=left.data){
        return  false;
      }
      right=right.next;
      left=left.next;
    }
    return true;
}
//get maximum twin sum of a even linked list
int maxTwinSum(){
  Node mid=getRightMiddleElement();
  Node right=reversellbyIterativePrecess(mid);
  Node left=head;
  int maxSum=0;
  while(right!=null){
      int sum=(right.data+left.data);
      maxSum=Math.max(sum, maxSum);
      right=right.next;
      left=left.next;
  }
  return maxSum;
}
public static void main(String[] args) {
   LinkedList ll= new LinkedList();
    // for(int i=1;i<=5;i++){
      ll.insertatEnd(100);
      ll.insertatEnd(9);
      ll.insertatEnd(10);
      ll.insertatEnd(1);
// } 
      
     System.out.println(ll.maxTwinSum());
  }
}