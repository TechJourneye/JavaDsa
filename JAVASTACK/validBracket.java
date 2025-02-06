
import java.util.*;

public class validBracket{

    public static boolean validBracket(String Str){
        Stack<Character> st=new Stack<>();
        int n=Str.length();
        char openingBracket='(';
        char closingBracket=')';
        if(Str.charAt(0)==closingBracket) return false;
        for(int i=0;i<n;i++){
            char ch=Str.charAt(i);
            if(ch==openingBracket){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                if(st.peek()==openingBracket) st.pop();
            }
        }

        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }

        if(!st.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean isDuplicate(String str){
              Stack<Character> s=new Stack<>();
              for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(ch==')'){
                    int count=0;
                    while(s.peek()!='('){
                        s.pop();
                        count++;
                    }
                    if(count<1){
                        return true;
                    }else s.pop();
                }else{
                    s.push(ch);
                }
              }
              return false;
    }

   

      
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str="((a+b)+(7+0))";
        System.out.println(isDuplicate(str));

    }
}