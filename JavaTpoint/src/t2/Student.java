
package t2;

public class Student {
    int roll;
    String name,course;
    float fee;
    public Student(int roll,String name,String course){
        this.roll=roll;
        this.name=name;
        this.course=course;
    }
    public Student(int roll,String name,String course,float fee){
        this(roll, name, course);
        this.fee=fee;
    }   
    public void display(){
        System.out.println(roll+" , "+name+" , "+course+" , "+fee);
    }
    public static void main(String[] args) {
        Student st = new Student(100, "Alu", "CSE");
        Student st2 = new Student(200, "Lol", "English", 1234.43f);
        st.display();
        st2.display();
    }
}
