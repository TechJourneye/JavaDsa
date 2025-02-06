public class abstract1{

    public static void main(String[] args) {
         mustange m1=new mustange();
         m1.changeColor();
         System.out.println(m1.color);
    }
}

abstract  class Animal{
    String color;
    Animal(){
        System.out.println("animal constructor is called...");
        color="brown";
    }
   void eat(){
    System.out.println("Animal eats");
   }

   abstract void walk();
}

class horse extends Animal{
    horse(){
        System.out.println("horse constructor is called...");
    }
    void walk(){
        System.out.println("walk on 4 legs");
    }
    void eat(){
        System.out.println("eat grass");
    }
    void changeColor(){
        color="dark brown";
    }
}

class mustange extends horse{

    public mustange() {
        System.out.println("mustange constructor is called...");
    }
    
}