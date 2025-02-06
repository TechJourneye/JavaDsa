
import java.util.Comparator;
import java.util.PriorityQueue;

class pq{
  
    public static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public  int compareTo(Student s2){
           return  this.rank-s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("abc",5));
        pq.add(new Student("abc",40));
        pq.add(new Student("abc",20));
        pq.add(new Student("abc",2));
        pq.add(new Student("abc",50));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"-> "+pq.peek().rank);
            pq.remove();
        }
    }
}