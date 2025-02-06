public class prifix{

    public static class Node{
      Node children[]=new Node[26];
      boolean eow=false;
      int freq;
      Node(){
        for(int i=0;i<26;i++){
          children[i]=null;
          freq=1;
        }

      }
    }
    public static Node root=new Node();
     
    public static void insert(String word){
      Node curr=root;
      for(int i=0;i<word.length();i++){
          int idx=word.charAt(i)-'a';
          if(curr.children[idx]==null){
              curr.children[idx]=new Node();
          }else{
            curr.children[idx].freq++;
          }
          curr=curr.children[idx];
      }
      curr.eow=true;
    }

    public static boolean search(String word){
      Node curr=root;
      for(int i=0;i<word.length();i++){
          int idx=word.charAt(i)-'a';
          if(curr.children[idx]==null){
             return false;
          }
          curr=curr.children[idx];
      }
      return curr!=null&&curr.eow;
    } 
    //prefix find 

    public static void findPrefix(Node root,String ans){
if(root==null){
    return;
}
      if(root.freq==1){
        System.out.println(ans);
        return;
      }
        for(int i=0;i<root.children.length;i++){
             if(root.children[i]!=null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
             }
        }
    }
    
    public static boolean wordBreak(String key){
      if(key.length()==0){
        return true;
      }
      for(int i=1;i<=key.length();i++){
        if(search(key.substring(0,i))&&
          wordBreak(key.substring(i))){
            return true;
          }
      }

      return false;
    }
    public static boolean prefixFound(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
      String word[]={"i","a","there","their","any","thee","hi","like","sumsun","ilikesumsung"};
      String words[]={"zebra","dog","duck","dove"};

      for(int i=0;i<words.length;i++){
          insert(words[i]);
      }
      System.out.println(prefixFound("duckk"));
    }
}