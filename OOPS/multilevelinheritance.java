public class  multilevelinheritance{

    public static void main(String[] args) {
     Dog d1=new Dog();
     d1.breaths();
}
}

class Animal{
    int legs;

    // public Animal() {
    //     this.legs=legs;
    // }

    void breaths(){
        System.out.println("breaths");
    }

    void eat(){
        System.out.println("eats food");
    }
}

//derived class/subclass
 class Mammal extends Animal{
    int legs;
 }

 class Dog extends Mammal{
    String breed;
 }