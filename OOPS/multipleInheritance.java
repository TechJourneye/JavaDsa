class multipleInheritance{

    public static void main(String[] args) {
        beer b1=new beer();
        b1.meatEater();
    }
}

interface Harvivour{
    void vegeater();
}
interface Carnivour{
    void meatEater();
}

class beer implements Harvivour,Carnivour{
    public void vegeater() {
        System.out.println("eat grass");
    };
    public void meatEater() {
        System.err.println("eat meat");
    };
}