public class classes{

    public static void main(String[] args) {
     Fish shark=new Fish();
     shark.breaths();
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
class Fish extends Animal{
      int fins;

      void type(){
        System.out.println("salted water fish");
      }
}