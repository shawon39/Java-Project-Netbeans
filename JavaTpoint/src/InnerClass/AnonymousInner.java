package InnerClass;

abstract class AnonymousInner {
    abstract void lol();
    abstract void call();
}
class test {
    public static void main(String[] args) {
        AnonymousInner st = new AnonymousInner(){
            @Override
            void lol(){
              System.out.println("Just Lol !!");  
            }
            @Override
            void call(){
                System.out.println("Called !!");
            }
        }; 
        st.lol(); st.call();
    }
}
