

public class trie{

      public static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        Node(){
          for(int i=0;i<26;i++){
            children[i]=null;
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

      public static int countSubstring(Node root){
       if(root==null){
        return 0;
       }
         int count=0;
        for(int i=0;i<26;i++){
         if(root.children[i]!=null){
          count +=countSubstring(root.children[i]);
         }
        }
        return count+1;
      }


    public static String ans="";
      public static void longestWord(Node root,StringBuilder temp){

        for(int i=25;i>=0;i--){

          if(root.children[i]!=null && root.children[i].eow==true){
            char ch=(char)(i+'a');
            temp.append(ch);
            if(temp.length()>ans.length()){
            ans=temp.toString();
            }
            longestWord(root.children[i], temp);
            temp.deleteCharAt(temp.length()-1);
          }
      
        }
      }
      public static void main(String[] args) {
        String words[]={"a","app","apple","apply","ap","banana","appl"};
        String str="ababa";
        for(int i=0;i<words.length;i++){
           insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
       System.out.println(ans);
      }
}