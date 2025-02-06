public class setithBit{
 
    public static int setithbit(int n,int  i){
      int bitMask=1<<i;
      return n|bitMask;

    //  return n;
    }
    
    public static int clearIthBit(int n,int i){
        int bitMask=~(1<<i);
        
        return (n&bitMask);
    }
    
    public static int updateithBit(int n,int i,int newBit){
        // if(newBit==0){
        //     return clearIthBit(n, i);
        // }else{
        //     return setithbit(n, i);
        // }

        n=clearIthBit(n, i);
        int bitMask=newBit<<i;
        return n|bitMask;
    }
    
    public static int clearlastithbits(int n,int i){
        int one=~0;
         int bitMask=one<<i;
         return n&bitMask;
    }

    public static int clearinRange(int n,int mr,int Mr){
        // int a=(~0)<<(Mr+1);
        // int b=0;
        // for(int i=0;i<=mr-1;i++) {
        //  b=setithbit(b, i);
        // }
        // int mainNo=a|b;

        // return n&mainNo;
        int a=((~0)<<(Mr+1));
        int b=(1<<mr)-1;
        int bitMask=a|b;
        
        return n&bitMask;
    }

    public static boolean powerof2(int n){
        return (n&(n-1))==0;
    }
    public static void main(String[] args) {
       System.out.println(powerof2(32)); 
    // System.out.println(setithbit(1, 0)); 
    } 
}