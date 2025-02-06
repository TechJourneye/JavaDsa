
public class practice {
     public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
     }

     public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
       return root ;
    }

    public static void inOrder(Node root){
                if(root==null){
                    return;
                }
                inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
            }

    //  public static class binaryTree{
    //    static  int idx=-1;
    //     public static Node buildTree(int nodes[]){
    //         idx++;
    //          if(nodes[idx]==-1){
    //           return null;
    //          }
    //          Node newNode=new Node(nodes[idx]);
    //          newNode.left=buildTree(nodes);
    //          newNode.right=buildTree(nodes);
    //          return newNode;
    //     }
    //     public static void preorder(Node root){
    //         if(root==null){
    //             System.out.print(-1+" ");
    //             return;
    //         }
    //     System.out.print(root.data+" ");
    //     preorder(root.left);
    //     preorder(root.right);
    //     }
    //     // inorder
    //     public static void inOrder(Node root){
    //         if(root==null){
    //             return;
    //         }
    //         inOrder(root.left);
    //     System.out.print(root.data+" ");
    //     inOrder(root.right);
    //     }

    //     public static void postorder(Node root){
    //         if(root==null){
    //             return;
    //         }
    //     postorder(root.left);
    //     postorder(root.right);
    //     System.out.print(root.data+" ");
    //     }

    //     public static void levelorder(Node root){
    //       Queue<Node> q=new LinkedList<>();
    //       q.add(root);
    //       q.add(null);

    //       while(!q.isEmpty()){
    //          Node currNode=q.remove();
    //          if(currNode==null){
    //             System.out.println();
    //             if(q.isEmpty()){
    //                 break;
    //             }else{
    //                 q.add(null);
    //             }
    //          } else{
    //             System.out.print(currNode.data+" ");
    //             if(currNode.left!=null){
    //                 q.add(currNode.left);
    //             }
    //             if(currNode.right!=null){
    //                 q.add(currNode.right);
    //             }
    //          }
    //       }
    //     }
    //  }

    public static void main(String[] args) {
        int nodes[]={5,2,3,1,7};
        Node root=null;
        for (int i = 0; i < nodes.length; i++) {
              root=insert(root, nodes[i]); 
        }
         inOrder(root);
    }
}
