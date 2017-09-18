package t1;
    
public class TestStudent3 { 
  
    public static void main(String[] args) {
        
       //creating an object of Student
        Student st = new Student();
        Student st2 = new Student(); 
        
        //Initializing objects 
        st.id=5; 
        st.name="Shawon!!"; 
        st2.id=10; 
        st2.name="Rahat!!";
        
        //Printing data
        System.out.println(st.id+"\n"+st.name); //accessing member through reference variable
        System.out.println(st2.id+"\n"+st2.name); //accessing member through reference variable
    }
}