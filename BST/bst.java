

import java.util.ArrayList;

class bst{

    public static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
        }
    }
  
    public static Node insert(Node root,int val){
         if(root==null){
            return new Node(val);
            // return root;
         }else if(val<root.data){
            root.left=insert(root.left, val);
         }else{
            root.right=insert(root.right, val);
         }
         return root;
    }
  /*
   * search in a BST
   */
  public  static boolean keySearch(Node root,int key){
    if(root==null){
        return false;
    }
    if(root.data==key){
        return true;
    }else if(key<root.data){
        return keySearch(root.left, key);
    }else{
        return keySearch(root.right, key);
    }

  }
    public static void Inorder(Node root){
        if(root==null) return;
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
/*
 * delete in bst
 */

 public static Node delete(Node root,int val){
    if(root.data<val){
        root.right=delete(root.right, val);
    }else if(root.data>val){
        root.left=delete(root.left, val);
    }
    else{//root.data==val
        if(root.left==null&&root.right==null){
            return null;
        }
        if(root.left==null){
            return root.right;
        }
        if(root.right==null){
            return root.left;
        }

        Node IS=inorderSuccessor( root.right);
        root.data=IS.data;
        root.right=delete(root.right, IS.data);
    }
    return root;
 }
 
 public static Node inorderSuccessor(Node root){
        while(root.left!=null) {
            root=root.left;
        }
        return root;
 }
/*
 * print in range
 */

 public static void printInrange(Node root,int k1,int k2){
    if(root==null){
        return;
    }
        // Traverse left subtree if there's a possibility of values within range
        if (root.data >= k1) {
            printInrange(root.left, k1, k2);
        }
        
        // Print current node if it's within the range
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }
    
        // Traverse right subtree if there's a possibility of values within range
        if (root.data <= k2) {
            printInrange(root.right, k1, k2);
        }
    // if(root.data>=k1&&root.data<=k2){
    //     printInrange(root.left, k1, k2);
    //     System.out.print(root.data+" ");
    //     printInrange(root.right, k1, k2);
    // }else if (root.data<k1) {
    //      printInrange(root.left, k1, k2);
    // }else{
    //     printInrange(root.right, k1, k2);
    // }
 }
 /*
  * root to leaf print all paths
  */
  public static void  printPath(ArrayList<Integer> path){
    for(int i=0;i<path.size();i++){
        System.out.print(path.get(i)+"->");
    }
    System.out.println("null");
  }
  public static void printrootToleaf(Node root,ArrayList<Integer> path){
    if(root==null){
        return;
    }
    path.add(root.data);
  if(root.left==null&&root.right==null){
    printPath(path);
  }
   
     printrootToleaf(root.left, path);
     printrootToleaf(root.right, path);
     path.remove(path.size()-1);
  } 
  /*
   *  check if the BST is valod
   */
  public static boolean  isValidbst(Node root,Node min,Node max){
    if(root==null ){
        return true;
    }
    if(min!=null&&root.data<=min.data){
        return false;
    }
    else if(max!=null&&root.data >=max.data){
        return false;
    }

    return isValidbst(root.left, min, root)&&isValidbst(root.right, root, max);
  }

  /*
   * Mirror BST
   */
  public static Node MirrorBst(Node root){
    if(root==null){
        return null;
    }
    Node leftMirror=MirrorBst(root.left);
    Node rightMirror=MirrorBst(root.right);
    root.left=rightMirror;
    root.right=leftMirror;
    return root;
  }
    public static void main(String[] args) {
       int values[] ={8,5,3,6,10,11,14};
       Node root=null;
       for(int i=0;i<values.length;i++){
        root= insert(root, values[i]);
       }
        Inorder(root);
        System.out.println();
    //  if(keySearch(root,2)){
    //     System.out.println("founnd");
    //  }else{
    //     System.out.println("not found");
    //  }
      root=MirrorBst(root);
      Inorder(root);
    }
}