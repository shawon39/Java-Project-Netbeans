package Gui;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class tuna extends JFrame {

    private JLabel item1;

    public tuna() {
        super("The Title bar");
        setLayout(new FlowLayout());
        
        item1 = new JLabel("This is Sentance");
        item1.setToolTipText("This Is Gonna show up on hover!");
        add(item1); 
    }  

}
