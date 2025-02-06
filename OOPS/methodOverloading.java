public class methodOverloading{

    public static void main(String[] args) {
        calculator c1=new calculator();
        System.out.println(c1.sum(1, 2));
        System.out.println(c1.sum((float)1.5, (float)2.5));
        System.out.println(c1.sum(1, 2,3));

    }
}

class calculator{
    int sum(int a,int b){
        return a+b;
    }

    float sum(float a,float b){
        return (a+b);
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }
}