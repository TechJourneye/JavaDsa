public class compress{
public static void compress(StringBuilder str) {
      StringBuilder st=new StringBuilder("");
      int k=0;
      for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        
         while(i+1<str.length()&&ch==str.charAt(i+1)){
             k++;
             i++;
         }
            
        st.append(ch);

         if(k>1){
            st.append(k);
         }
         k=1;
      }
      System.out.println(st);
}

    public static void main(String[] args) {
        compress(new StringBuilder("aavvaaabbbbcccccce"));
    }
}