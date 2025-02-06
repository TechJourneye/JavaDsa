
import java.util.ArrayList;

class bst2{

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
// max size of a BST
   public static int maxBST=0;

   public static Info largestBST(Node root){
    if(root==null) return new Info(true, 0, Integer.MAX_VALUE,Integer.MIN_VALUE);
       Info leftInfo=largestBST(root.left);
       Info rightInfo=largestBST(root.right);
       int size=leftInfo.size+rightInfo.size+1;
       int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
       int max=Math.max(root.data,Math.max(rightInfo.max,leftInfo.max));

       if(root.data<=leftInfo.max||root.data>=rightInfo.min){
        return new Info(false,size,min,max);
       }

       if(rightInfo.isBST&&leftInfo.isBST){
        maxBST=Math.max(maxBST, size);
        return new Info(true, size, min, max);
       }

       return new Info(false, size, min, max);
   }

    // sorted array to perform balanced binary search trees
    public static Node createBST(ArrayList<Integer> inorder,int st,int end){
        if(st>end) return null;

        int mid=(st+end)/2;

    Node root=new Node(inorder.get(mid));

    root.left=createBST(inorder, st, mid-1);
    root.right=createBST(inorder, mid+1, end);

    return root;
    }

    // preorder BST 
    public static void preorder(Node root){
        if(root==null)return ;
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //inorder BSt
    public static void inorder(Node root,ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        inorder(root.left,inorder);
        inorder.add(root.data);
        inorder(root.right,inorder);
    }
    // make a balanced binary tree 
    public static Node disbalancedtoBalancedBST(Node root){
        //inorder sorted
        ArrayList<Integer> inorder=new ArrayList<>();
        inorder(root, inorder);

        //create BST
       root=createBST(inorder, 0, inorder.size()-1);
       return root;
    }
    // merge two bsts
    public static void getInorder(Node root,ArrayList<Integer> arr1){
          if(root==null)  {
             return;
          }
          getInorder(root.left, arr1);
          arr1.add(root.data);
          getInorder(root.right, arr1);
    }
    public static Node mergeBSTs(Node root1,Node root2){
        //step 1
        ArrayList<Integer> arr1=new ArrayList<>();
        getInorder(root1,arr1);

        ArrayList<Integer> arr2=new ArrayList<>();
        getInorder(root2,arr2);

        //merge
        int i=0;int j=0;
        ArrayList<Integer> finalArr=new ArrayList<>();
        while(i<arr1.size()&&j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        return createBST(finalArr,0,finalArr.size()-1);

    }
    public static void main(String[] args) {

        // Node root=new Node(50);

        // root.left=new Node(30);
        // root.left.left=new Node(5);
        // root.left.right=new Node(20);

        // root.right=new Node(60);
        // root.right.left=new Node(45);
        // root.right.right=new Node(70);
        // root.right.right.left=new Node(65);
        // root.right.right.right=new Node(80);
         Node root1=new Node(2);
         root1.left=new Node(1);
         root1.right=new Node(4);

         Node root2=new Node(9);
         root2.left=new Node(3);
         root2.right=new Node(12);

         Node root= mergeBSTs(root1, root2);
         preorder(root);
    }
}