package Gui;
//
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
//

public class apples {
//
//    public static void main(String[] args) {
//
//        String fn = JOptionPane.showInputDialog("Enter First Number");
//        String sn = JOptionPane.showInputDialog("Enter Second Number");
//        
//        int num1 = Integer.parseInt(fn);
//        int num2 = Integer.parseInt(sn);
//        
//        ImageIcon icon = new ImageIcon("C:\\Users\\shsha\\Desktop\\BabyBathing.jpg");
//        
//       // JOptionPane.showMessageDialog(null, "The Sum is: "+(num1+num2));
//        //JOptionPane.showMessageDialog(null, "The Sum is: "+(num1+num2),"Simple Math", JOptionPane.PLAIN_MESSAGE,icon);
//        JOptionPane.showMessageDialog(null, "The Ans Is: "+(num1+num2),"This is Title", JOptionPane.PLAIN_MESSAGE);
//    }
//}

    public static void main(String[] args) {

        tuna buckey = new tuna(); 
        buckey.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buckey.setSize(275,180);
        buckey.setVisible(true);
        buckey.setLocationRelativeTo(null);
        buckey.setResizable(false);
        
    }

}
