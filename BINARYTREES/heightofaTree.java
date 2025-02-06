// import java.lang.classfile.components.ClassPrinter;
// import java.lang.classfile.components.ClassPrinter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
class heightofaTree{
    public static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
/// height of a tree function 
    public static int height(Node root){
        if(root==null){
            return 0;
        }
             int lh=height(root.left);
             int rh=height(root.right);

             return Math.max(lh, rh)+1;

    } 

    // count of nodes function 
    public static int countNOdes(Node root){
         if(root==null){
            return 0;
         }
        int lcount=countNOdes(root.left);
        int rcount=countNOdes(root.right);

        int totalcount =lcount+rcount+1;
        return totalcount;
    }

    //total sum ao nodes
    public static int sumofNodes(Node root){
        if(root==null){
            return 0;
        }
        int lsum=sumofNodes(root.left);
        int rsum=sumofNodes(root.right);

        int totalSum=lsum+rsum+root.data;
        return totalSum;
    }

    public static int Diameter(Node root){
        if(root==null){
            return 0;
        }
        int Ldiam=Diameter(root.left);
        int Lheight=height(root.left);
        int Rdiam=Diameter(root.right);
        int Rheight=Diameter(root.right);

        int selfDia=Lheight+Rheight+1;
        return Math.max(selfDia,Math.max(Ldiam, Rdiam));

    }

     public static class Info{
        int dia,ht;
        Info(int dia,int ht){
            this.dia=dia;
            this.ht=ht;
        }
     }
     public static Info Diameter2(Node root){
       if(root==null){
        return new Info(0, 0);
       }
        Info lDia=Diameter2(root.left);
        Info rDia=Diameter2(root.right);
       int finalDia=Math.max(Math.max(lDia.dia, rDia.dia),lDia.ht+rDia.ht+1);
       int finalHt=Math.max(lDia.ht,rDia.ht)+1;

        return new Info(finalDia,finalHt);

     }

     public static boolean isIdentical(Node node,Node subroot){
        if(node==null&&subroot==null){
            return true ;
        }else if(node==null||subroot==null||subroot.data!=node.data){
            return false;
        }
        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
     }

     public static boolean isSubtree(Node root,Node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){
          if(isIdentical(root,subroot)){
            return true;
          } 
        }

        return isSubtree(root.left, subroot)||isSubtree(root.right, subroot);
     }

    /* 

         /// top view of a tree

     */
     public static class Info2{
            int hd;
            Node root;
           public Info2(Node root,int hd){
             this.hd=hd;
             this.root=root;
            }
            }
     public static void TopviewofATree(Node root){
             Queue<Info2> q=new LinkedList<>();
             HashMap<Integer,Node> map=new HashMap<>();
              
             int max=0; int min=0;
             q.add(new Info2( root,0));
             q.add(null);

             while(!q.isEmpty()){
                Info2 currNode=q.remove();

                if(currNode==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(currNode.hd)){
                        map.put(currNode.hd, currNode.root);
                    }
                    if(currNode.root.left!=null){
                        q.add(new Info2(currNode.root.left,currNode.hd-1));
                        min=Math.min(min,currNode.hd-1);
                    }
                    if(currNode.root.right!=null){
                        q.add(new Info2(currNode.root.right, currNode.hd+1));
                        max=Math.max(max, currNode.hd+1);
                    }
                }
             }

             for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data);
             }
     }
     /* 
         ///  k th level of a tree recursion process

     */
    public static void KthlevelofRoot(Node root,int k,int level){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return ;
        }
        KthlevelofRoot(root.left, k, level+1);
        KthlevelofRoot(root.right, k, level+1);
    }

    /*
      kth level of a tree by level order  traversal
     */

     public static void KthlevelofRootbyLeveltrav(Node root,int k){
            
        Queue<Node> q=new LinkedList<>();
            q.add(root);
            int level=1;
         while(!q.isEmpty()){
            int levelSize=q.size();
            if(level==k){
              for(int i=0;i<levelSize;i++){
                 Node currNode=q.remove();
                 System.out.print(currNode.data);
              }
              return;
            }

            for(int i=0;i<levelSize;i++){
                Node curNode=q.poll();
                if(curNode.left!=null)q.add(curNode.left);
                if(curNode.right!=null)q.add(curNode.right);
            }
              level++;
                   
         }
     }
/*
 * lowest common ancestor 
 */
     public static boolean getpath(Node root,int n,ArrayList<Node> path){
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }
           boolean leftInfo= getpath(root.left, n, path);
           boolean rightInfo= getpath(root.right, n, path);

          if(leftInfo||rightInfo){
            return true;
          }
          path.remove(path.size()-1);
          return false;

     }

     public static Node LCA(Node root,int n1,int n2){
            ArrayList<Node> path1=new ArrayList<>();
            ArrayList<Node> path2=new ArrayList<>();

            getpath(root,n1,path1);
            getpath(root,n2,path2);
            int i=0;
            if(path1.isEmpty()||path2.isEmpty()){
                // System.out.println("ancestor does not exists");
                return null;
            }else{
                for(;i<path1.size()&&i<path2.size();i++){
                    if(path1.get(i)!=path2.get(i)) break;
              }
  
            }
           
            return path1.get(i-1);
     }

     public static Node LCA2(Node root,int n1,int n2){
        if(root==null||root.data==n1||root.data==n2){
            return root;
        }
        Node leftlca =LCA2(root.left, n1, n2);
        Node rightlca=LCA2(root.right, n1, n2);
         if(leftlca==null){
            return rightlca;
         }
         if(rightlca==null){
            return leftlca;
         }

         return root;
    }
/*
 * Minimum distance between two nodes
 */

  public static int lcaTon(Node root,int n){
    if(root==null){
        return -1;
    }
       if(root.data==n){
        return 0;
       }
      int leftdis= lcaTon(root.left, n);
      int rightdis=lcaTon(root.right, n);

     if(leftdis==-1&&rightdis==-1){
        return -1;
     }else if(rightdis==-1){
        return leftdis+1;
     }else{
       return  rightdis+1;
     }
  }
public static int minDist(Node root,int n1,int n2){
          Node lca=LCA(root, n1, n2);
          int dist1=lcaTon(lca,n1);
          int dist2=lcaTon(lca,n2);
          return dist1+dist2;
}
  /*
  Kth ancestor of a node 
  */  
   public static int kthAncestor(Node root,int n,int k){
    if(root==null){
        return -1;
    }
    if(root.data==n){
        return 0;
    }
    int leftdis=kthAncestor(root.left, n, k);
    int rightDis=kthAncestor(root.right, n, k);
     
    if(leftdis==-1&&rightDis==-1){
        return -1;
    }
    int max=Math.max(leftdis, rightDis);
    if(max+1==k){
        System.out.println(root.data);
        return root.data;
    }
    return max+1;
   }

   /*
    * transform sum tree
    */
    public static int transformTree(Node root){
        if(root==null) return 0;

        int leftchild=transformTree(root.left);
        int rightchild=transformTree(root.right);

        int data=root.data;

        int leftroot=root.left==null?0:root.left.data;
        int rightroot=root.right==null?0:root.right.data;

        root.data=leftroot+leftchild+rightroot+rightchild;
        System.out.println(root.data);

        return data;
    }
    public static void main(String[] args) {////////////////////////////////////////////////////////
        /*
            1
           / \
          2   3
         / \  / \ 
         4  5 6  7       
        */

        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.right=new Node(7);
        root.right.left=new Node(6);
          /*
            2
           / \
          4   5 
        */
      Node subroot=new Node(2);
      subroot.left=new Node(4);
      subroot.right=new Node(5);
      
// kthAncestor(root, 4, 1);
transformTree(root);
   System.out.println(root.data);
   System.out.println(root.left.data);
   System.out.println(root.left.left.data);
   System.out.println(root.right.data);
   System.out.println(root.right.right.data);

    }
}