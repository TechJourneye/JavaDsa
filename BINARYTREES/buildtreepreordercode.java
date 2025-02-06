
import java.util.LinkedList;
import java.util.Queue;

class buildtreepreordercode{
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int d){
            this.data=d;
            this.left=null;
            this.right=null;
        }
    } 
    public static class BinaryTree{
        static  int idx=-1;
        public  Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
// preorder traversal 
        public static void preOrder(Node root){
            if(root==null){
                System.out.print(-1+" ");
                return;
            }
          System.out.print(root.data+" ");
          preOrder(root.left);
          preOrder(root.right);
        }
        // Inorder traversal 
        public static void inOrder(Node root){
            if(root==null){
                return;
            }
               inOrder(root.left);
               System.out.print(root.data+" ");
               inOrder(root.right);
        }
        //postOrder traversal 
        public static void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        // lavelorder  traversal
        public static void levelOrder(Node root){
            if(root==null){
                System.out.println("Root is empty");
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                  System.out.println();   
                  if(q.isEmpty()){
                    break;
                  }else{
                    q.add(null);
                  }
                } else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                   
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);   
        // tree.inOrder(root);
        // tree.postOrder(root);
        tree.levelOrder(root);
    }
}