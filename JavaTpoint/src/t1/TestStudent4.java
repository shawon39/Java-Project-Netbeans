package t1;

public class TestStudent4 {

    public static void main(String[] args) {

//        Student1 st = new Student1(100, "Shawon");
//        Student1 st2 = new Student1(200, "Rabbi");
//        Student1 st3 = new Student1(300, "Kamrul");

//        Student1 st = new Student1();
//        Student1 st2 = new Student1();
//        Student1 st3 = new Student1();

        Student1 st = new Student1(),st2 = new Student1(),st3 = new Student1();

        st.insert(100, "Shawon");
        st2.insert(1200, "Sha66won");
        st3.insert(1300, "Shaw77on");

        st.display();
        st2.display();
        st3.display();
    }
}
