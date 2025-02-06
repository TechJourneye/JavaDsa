public class convertUppercase{
     public static StringBuilder upper(StringBuilder str){
        
       str.setCharAt(0, Character.toUpperCase(str.charAt(0)));

       for(int i=1;i<str.length();i++)  {

          if(str.charAt(i)==' '&&i<str.length()-1){
            i++;
             str.setCharAt(i, Character.toUpperCase(str.charAt(i)));
          }
       }

        return str;
     }
    public static void main(String[] args) {
          System.out.print(upper(new StringBuilder("subhadip das ")));
    }
}