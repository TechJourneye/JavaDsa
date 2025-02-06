class friendspair{

    public static int friendpair(int n){

        if(n==1||n==2) return n;

        return friendpair(n-1)+(n-1)*friendpair(n-2);
    }
    public static void main(String[] args) {
         System.out.println(friendpair(3));
    }
}