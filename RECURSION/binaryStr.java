class binaryStr{
    
    public static void binaryStr(int n,int lastIdx,String str){
          
    if(n==0){
        System.out.println(str);
        return;
    }
        //kaj
        binaryStr(n-1, 0, str+'0');
        if(lastIdx==0){
            binaryStr(n-1, 1, str+'1');
        }
    }
    public static void main(String[] args) {
      binaryStr(3, 0, "");   
    }
}