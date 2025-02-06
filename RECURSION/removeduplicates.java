public class removeduplicates{
public static String remDup(StringBuilder sb,String str,boolean arr[],int i){
   
if(i==str.length()){
    return sb.toString();
}

  if(!arr[str.charAt(i)-'a']){
    arr[str.charAt(i)-'a']=true;
    sb.append(str.charAt(i));
  }
   return remDup(sb, str, arr, i+1);
}

    public static void main(String[] args) {
        String str="subhadipdas";
        boolean b[]=new boolean[26];
        System.out.println(remDup( new StringBuilder(""),str, b,0));
    }
}