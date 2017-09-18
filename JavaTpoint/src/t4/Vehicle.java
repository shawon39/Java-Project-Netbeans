
package t4;

interface Vehicle {
    void start();
    void stop();
    default void lol(){
        System.out.println("");
    }
}

class CNG implements Vehicle{
    @Override
    public void start(){
       System.out.println("Start"); 
    }
  
    @Override
    public void stop(){
        System.out.println("stop");
    }
}

class lol extends CNG{  
    @Override
    public void stop(){
        System.out.println("stop");
    }
}
