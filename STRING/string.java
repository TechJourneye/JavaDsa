
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


 
public class string{

    public static boolean palindrome(String name){
        Queue<Character> q=new LinkedList<>();
        Stack<Character> s=new Stack<>();
    
        for(int i=0;i<name.length();i++){
            s.push(name.charAt(i));
        }
        for(int i=0;i<name.length();i++){
            q.add(name.charAt(i));
        }
    
        while(!q.isEmpty()&&!s.isEmpty()){
             char l=s.pop();
             char f=q.remove();
             if(l!=f){
                return false;
             }
        }
        if(!q.isEmpty()){
            return false;
        }else if(!s.isEmpty()){
            return false;
        }
    
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      
        String name;
        name=sc.nextLine();
       
     if(palindrome(name)){
        System.out.println("palindrome");
     }else{
        System.out.println("not palindrome");
     }
        
    }
}