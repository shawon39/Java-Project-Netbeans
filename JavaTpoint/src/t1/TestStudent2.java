package t1;
    
public class TestStudent2 {  
    int id;  //field or data member or instance variable  
    String name;
    public static void main(String[] args) {
        Student st = new Student(); //creating an object of Student
        st.id=5; 
        st.name="Shawon!!"; 
        System.out.println(st.id+"\n"+st.name); //accessing member through reference variable  
    }
}