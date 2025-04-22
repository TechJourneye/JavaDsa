public class linkedlistadd{
  static Node head;
  static Node tail;
  static int size=0;

   class  Node{
      int data;
      Node next;
      Node(int data){
         this.data=data;
         this.next=null;
      }
   }
       void addFirst(int data){
         size++;
          Node newNode=new Node(data) ;
            if(head==null){
               head=tail=newNode;
               return;
            }
          // newnode's next points to head;
          newNode.next=head;
          //head will point to current node;
          head=newNode;

      }
       void addLast(int data){
         Node newNode=new Node(data);
         size++;
         if(head==null){
            head=tail=newNode;
            return;
         }
         //tail's next will be newNode
         tail.next=newNode;
         //tail will ponit to newnode
         tail=newNode;
       }
       void printLLreverse(Node temp){
         if(temp==null) return;
         
         printLLreverse(temp.next);
         System.out.print(temp.data+" ");
       }

       void printLL(){
           Node temp=head;
           while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
           }
           System.out.println("null");
           System.out.println();
       }

       void add(int idx,int data){
         Node newNode=new Node(data);
         if(idx==0){
            addFirst(data);
            return;
         }
         size++;
         Node temp=head;
         int i=0;
         while(i<idx-1){
            temp=temp.next;
            i++;
         }
         newNode.next=temp.next;
         temp.next=newNode;
       }
       void add(int data){
         Node newNode=new Node(data);
         size++;
         if(head==null){
            head=tail=newNode;
            return;
         }
         //tail's next will be newNode
         tail.next=newNode;
         //tail will ponit to newnode
         tail=newNode;
       }

       int remove1st(){
         if(head==null) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
         }
         if(size==1){
            int val =head.data;
            size=0;
            head=tail=null;
            return val;
         }
         size--;
         int val=head.data;
          head=head.next;
          return val;
       }

       int removeLast(){
         if(head==null) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
         }
         if(size==1){
            int val =head.data;
            size=0;
            head=tail=null;
            return val;
         }
         int val=tail.data;
          Node temp=head;
         for(int i=0;i<size-2;i++){
             temp=temp.next;
         }
         temp.next=null;
         tail=temp;
         size--;
         return val;
       }
       int isfounditerative(Node head,int key){
            Node temp=head;
            int idx=0;
            while(temp!=null){
               if(temp.data==key) return idx;
               temp=temp.next;
               idx+=1;
            }
            return -1;
       }

      private int helper(Node head,int key){
           if(head==null){
             return -1;
           }
           if(head.data==key){
            return 0;
           }
           int idx=helper(head.next, key);
           if(idx==-1){
            return -1;
           }

           return idx+1;

      }
       int recursiveSearch(Node head,int key){
          return helper(head,key);
        
       }
       void reverse(){
         if(head==null){
            System.out.println("LL is empty");
            return;
         }
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
       }

      int delete(int idx){
         if(idx==0){
           return remove1st();
         }
         int i=0;
         Node prev=head;
         Node curr=head;
         while(i<idx){
          prev=curr;
          curr=curr.next;
          i++;
         }
         int val=curr.data;
         prev.next=curr.next;
         return val;
      }
      int removenthNodefromend(int idx){
          int i=1;
          idx=size-idx;
          Node prev=head;
          while(i<idx){
           prev=prev.next;
           i++;
          }
          int val=prev.next.data;
          prev.next=prev.next.next;
          return val;
      }

      Node mid(){
         Node fast=head;
         Node slow=head;
         while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
         }
          return slow;
      }
      public boolean ispalindrome(){
       // mid find
       Node midNode=mid();
       //reverse the 2nd half
       Node prev=null;
       Node curr=midNode;
       Node next;
       while(curr!=null){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
       }
       Node left=head;
       Node right=prev;
       //checking condition
       while(right!=null){
         if(left.data!=right.data) return false;
         left=left.next;
         right=right.next;
       }
       return true;
      }
      boolean isCycle(){// floyd's CFA
         
      Node slow=head;
      Node fast=head;

      while(fast!=null&&fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if(slow==fast){
            return true;
           }
      }
      return false;
   }

//remove cycle
void removeCycle(){
   Node slow=head;
   Node fast=head;
 boolean flag=false;
   while(fast!=null&&fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
      if(slow ==fast){
         flag=true;
         break;
      }
   }

   if(flag==false){
      return;
   }
   slow=head;
   Node prev=null;
   while(fast!=slow){
      prev=fast;
      fast=fast.next;
      slow=slow.next;
   }
   prev.next=null;
}
Node midforMergeSort(Node head){
   Node fast=head.next;
   Node slow=head;
   while(fast!=null&&fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
   }
    return slow;
}
private  Node merge(Node head1,Node head2){
   Node mergedLL=new Node(-1);
   Node temp=mergedLL;

   while(head1!=null&&head2!=null){
       if(head1.data<=head2.data){
         temp.next=head1;
         head1=head1.next;
         temp=temp.next;
       }else{
         temp.next=head2;
         head2=head2.next;
         temp=temp.next;
       }
   }
   while(head1!=null){
      temp.next=head1;
      head1=head1.next;
      temp=temp.next;
   }
   while(head2!=null){
      temp.next=head2;
      head2=head2.next;
      temp=temp.next;
   }
   return mergedLL.next;
}
Node  mergeSort(Node head){
    if(head==null||head.next==null){
      return head;
    }
   // mid find
   Node mid=midforMergeSort(head);
   Node  rightMid=mid.next;
   mid.next=null;
   // call for left part
   Node newleft=mergeSort(head);
   //call for right part
   Node newRight=mergeSort(rightMid);

   return merge(newleft,newRight);

   
}
   int recursiveBina(int arr[],int key,int si,int ei){
         if(si>ei) return -1;
      // int si=0;
      // int ei=arr.length-1;
      int mid=si+(ei-si)/2;
      if(arr[mid]==key) return mid;

      if(arr[mid]>key){
          return recursiveBina(arr, key, si, mid-1);
      }
        return recursiveBina(arr, key, mid+1, ei);
      
   }
   Node zigZag(){
      //find mid
     Node mid=midforMergeSort(head);
     Node rightP=mid.next;
     mid.next=null;
   //reverse thr 2nd half
   Node prev=null;
   Node curr=rightP;
   Node next;
   while(curr!=null){
       next=curr.next;
       curr.next=prev;
       prev=curr;
       curr=next;
   }
   // alternate Merge
   Node LH=head;
   Node RH=prev;

   Node nextL,nextR;
   while(LH!=null&&RH!=null){
         nextL=LH.next;
         nextR=RH.next;
         LH.next=RH;
         RH.next=nextL;
    // update
    LH=nextL;
    RH=nextR;
   }
    return head;
   }
   public static void main(String[] args) {
   
      linkedlistadd ll=new linkedlistadd();
    
      System.out.println();
       ll.addLast(1);
       ll.addLast(5);
       ll.addLast(6);
       ll.addLast(4);
       ll.addLast(7);
      //  ll.addLast(8);

       ll.printLL();
       ll.zigZag();
       ll.printLL();
      // ll.removeCycle();
      // ll.printLL();
       System.out.println();
   
   }
   
}












// public class linkedlistadd{
//      public static class Node{
//         int data;
//         Node next;
//         public Node(int data){
//             this.data=data;
//             this.next=null;
//         }
//      }
//      public static Node head;
//      public static Node tail;
//      public static int size;
//      //print linked list
//      public void printLL(Node head){
//          Node temp=head;
//          while(temp!=null){
//             System.out.print(temp.data+"->");
//             temp=temp.next;
//          }
//          System.out.println();
//      }
//       ///add first in linked list
//      public void addFirst(int data){
//         Node newNode=new Node(data);
//         if(head==null){
//             head=tail=newNode;
//             size++;
//             return;
//         }
//         newNode.next=head;
//         head=newNode;
//         size++;
//      }
//      // add last
//      public void addLast(int data){
//         Node newNode=new Node(data);
//         if(head==null){
//             head=tail=newNode;
//             size++;
//             return;
//         }
//         tail.next=newNode;
//         tail=newNode;
//         size++;
//      }
//      // insert at any position
//      public void insertatPos(int data,int index ){
//          Node newnNode=new Node(data);
//          if(index==0){
//             addFirst(data);
//             size++;
//             return;
//          }
//          Node temp=head;
         
//          int i=0;
//          while(i<index-1&&temp!=null){
//             temp=temp.next;
//             i++;
//          }
//          if(temp==null){
//             System.out.print("position out of bounds");
//             return;
//          }
//          newnNode.next=temp.next;
//          temp.next=newnNode;
//          size++;
//      }
//      //remove first
//      int removeFirst(){
//         if(head==null){
//             return -1;
//         }else if(size==1){
//             int val=head.data;
//             head=tail=null;
//             size=0;
//             return val;
//         }
//         int val=head.data;
//         head=head.next;
//         size--;
//         return val;
//      }
//      //remove last
//      int removeLast(){
//        Node temp=head;
//        Node prev=head;
//        while (temp.next!=null) { 
//            prev=temp;
//            temp=temp.next;
//        }
//        int val=temp.data;
//        prev.next=null;
//        tail=prev;
//        size--;
//        return val;
//      }
//     public static void main(String[] args) {
//        linkedlistadd ll=new linkedlistadd();
//        ll.addFirst(4);
//        ll.addFirst(5);
//        ll.addFirst(9);
//        ll.addFirst(7);
//        ll.addLast(9);
//        ll.addLast(900000);
//        ll.insertatPos(70,2);
//        ll.printLL(head);
//        System.out.println(ll.removeLast());
//        ll.printLL(head);
//     }
// }