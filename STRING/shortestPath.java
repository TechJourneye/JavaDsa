public class shortestPath{

public static double  getShortestPath(String str){
    int y=0,x=0;
    for(int i=0;i<str.length();i++){
        if(str.charAt(i)=='E'){
            x++;
        }else if(str.charAt(i)=='W'){
            x--;
        }else if(str.charAt(i)=='N'){
            y++;
        }else{
            y--;
        }
        
    }
    y=y*y;
    x=x*x;
    
    return (float)Math.sqrt(x+y);
}

    public static void main(String[] args) {
     String str="WNEENESENNN" ;
     char ch1='a';
    char c=Character.toUpperCase(ch1);
     StringBuilder str1=new StringBuilder("");
     for(char ch='a';ch<='z';ch++){
        System.out.println(str1.append(ch));
     }
      System.out.println(getShortestPath(str));

    }
}