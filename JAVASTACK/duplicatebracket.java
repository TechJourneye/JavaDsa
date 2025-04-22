
import java.util.Stack;


public  class duplicatebracket{
     public static boolean validParenthasic(String str){
        Stack<Character> st=new Stack<>();

        for(int i=0;i<str.length();i++){
            Character ch=str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                 st.push(ch);
            }else{
                Character currch=st.peek();
                if(st.isEmpty()) return false;
                if(ch==']'&&currch=='['||ch=='}'&&currch=='{' 
                 ||ch==')'&&currch=='(') {
                    st.pop();
                 }else{
                    return false;
                 }
              
            }
            
        }
        if(st.isEmpty()) return true;
     
            return false;

    
     }
     public static boolean isDuplicate(String str){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==')'){
                int count =0;
                while(st.peek()!='('){
                    st.pop();
                    count++;
                } 
                if(count==0){
                    return true;
                }else{
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        return false;
     }
    public static void main(String[] args) {
        String str="({[]})";
        String str1="((a+b)+(7+0))";
        String str3="(((a+b)+(7+0)))";
       System.out.println(isDuplicate(str3));
    }
}