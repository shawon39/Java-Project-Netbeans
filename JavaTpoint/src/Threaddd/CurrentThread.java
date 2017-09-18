package Threaddd;

import javax.swing.JOptionPane;

public class CurrentThread extends Thread {

    @Override
    public void run() {
        System.out.println(currentThread().getName());
    }

    public static void main(String[] args) {
        CurrentThread lol1 = new CurrentThread();
        CurrentThread lol2 = new CurrentThread();
        CurrentThread lol3 = new CurrentThread();
        CurrentThread lol4 = new CurrentThread();
        CurrentThread lol5 = new CurrentThread();

        try {
            lol1.start();
            lol1.join();
            lol2.start();
            lol2.join();
            lol3.start();
            lol3.join();
            lol4.start();
            lol4.join();
            lol5.start();
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
}
