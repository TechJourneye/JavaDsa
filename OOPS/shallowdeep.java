class shallowdeep{
    
    public static void main(String[] args) {
        //shallow copy
        Student s1=new Student("Sudip Samanta",1);
          s1.marks[0]=90;
          s1.marks[1]=80;
          s1.marks[2]=100;

          Student s2=new Student(s1);

          s1.marks[2]=60;
          for(int i=0;i<3;i++){
            System.out.println(s2.marks[i]);
          }
    }
}

// shallow copy
class Student{
    String name;
    int roll;
    int marks[];
     Student(String name,int roll){
        this.name=name;
        this.roll=roll;
        this.marks=new int[3];
     }
    Student(Student s1){
         marks=new int[s1.marks.length];
         this.name=s1.name;
         this.roll=s1.roll;
         this.marks=s1.marks;
    }
}





// class Student{
//     String name;
//     int roll;
//     int[] marks;

//     Student(String name, int roll) {
//         this.name = name;
//         this.roll = roll;
//         this.marks = new int[3];
//     }

//     // Deep copy constructor
//     Student(Student s1) {
//         this.name = s1.name;
//         this.roll = s1.roll;
//         this.marks = new int[s1.marks.length]; 

       
//         for (int i = 0; i < s1.marks.length; i++) {
//             this.marks[i] = s1.marks[i];
//         }
//     }
// }
