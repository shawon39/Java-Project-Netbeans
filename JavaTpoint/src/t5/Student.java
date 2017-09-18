
package t5;

public class Student {
    private String name;
    public void setName(String name){
        this.name=name; 
    }
    public String getName(){
        return name; 
    }
}
class test5{
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("Shawon");
        System.out.println(st.getName());
    }
}