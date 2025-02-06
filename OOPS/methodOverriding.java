public class methodOverriding{

    public static void main(String[] args) {
     Mammal deer=new Mammal();
      deer.eat();

    }
}

class Animal{
    void eat(){
        System.out.println("eat anything");
    }
}

class Mammal extends Animal{
    void eat(){
        System.out.println("eat grass");
    }
}