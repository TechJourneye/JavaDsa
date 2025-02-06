public class interfacing{
    
    public static void main(String[] args) {
        
    }
}

interface cheesplayer{
    void moves();
}

class queen implements cheesplayer{
    public void moves(){
        System.out.println("up,down,left,right");
    }
}
