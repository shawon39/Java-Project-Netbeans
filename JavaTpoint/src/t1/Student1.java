
package t1;

public class Student1 {
    
    int id; 
    String name;
    
//    public Student1(int id, String name){
//        this.id=id; 
//        this.name=name; 
//    }
    
    void insert(int id, String name){
        this.id=id; 
        this.name=name; 
    }
    
    public void display(){
        System.out.println("ID: "+id+"\nName: "+name);
    }
}
