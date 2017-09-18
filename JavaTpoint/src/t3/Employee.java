
package t3;

public class Employee {
    int id; 
    String name; 
    Address address; 
    public Employee(int id,String name,Address address){
        this.id=id; 
        this.name=name; 
        this.address=address; 
    }
    
    public void display(){
        System.out.println(id+" , "+name);
        System.out.println(address.city+" , "+address.state+" ,"+address.country);
    }
    
    public static void main(String[] args) {
        Address ad = new Address("Dhaka", "BD", "Bangladesh");
        Address ad2 = new Address("CTG", "CT", "Bangladesh");
        
        Employee em = new Employee(10, "Nameless", ad); 
        Employee em2 = new Employee(200, "Nameless2", ad2);
        
        em.display();
        em2.display();
        
    }
}
