public class subset{
    static int track;
public static void subset(String str,String ans,int i){
     if(i==str.length()){
        System.out.println(ans+" -->");
        return;
     }
        //YES
    
        subset(str, ans+str.charAt(i), i+1);
         
        //NO
        subset(str, ans, i+1);
     
}


public static void main(String[] args) {
    String arr[]=new String[90];
         
     subset("on bur tr", "",  0);

   
}
}
