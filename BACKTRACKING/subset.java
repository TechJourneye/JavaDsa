public class subset{
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
     subset("celebraties on burmunda triangle", "",  0);
}
}
