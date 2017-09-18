
package Exception;

class TestThrow1 {

    static void validate(int age) {
        if (age < 18) {
            throw new ArithmeticException();
        } else {
            System.out.println("welcome to vote");
        }
    }

    public static void main(String args[]) {
        try {
            validate(44);
            System.out.println("TRY");
        } catch (ArithmeticException e) {
            System.out.println("CATCH");
        }
    }
}
