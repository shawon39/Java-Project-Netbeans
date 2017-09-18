package t5;

class TestArrayCopyDemo {

    public static void main(String[] args) {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
            'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 0, copyTo, 0, 6);
        System.out.println(new String(copyTo));
        System.out.println(new String(copyFrom));
    }
}
