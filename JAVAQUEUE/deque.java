
import java.util.Deque;
import java.util.LinkedList;

class deque{

    public static void main(String[] args) {
        Deque<Integer> dq=new LinkedList<>();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(3);
        dq.addLast(4);
        System.out.println(dq);
        dq.removeLast();
        System.out.println(dq);
    }
}