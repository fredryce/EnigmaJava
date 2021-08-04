//Xin Wang, Zack Fisher
//Pax2Part2 Enigma Machines
//10/13/2016
//This project incorporates the use of GUI and how the German Enigma machine works. i hate history. 
//Dr. DeenBushy Monday Wednesday 12:00 - 1:40

package pax2.part.pkg2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author xwang2945
 */
public class MyGUI extends JFrame{
    

    /**
     * @param args the command line arguments
     */
    public MyGUI(){           // Main frame that brings all the panels together.
        setTitle("Main Menu");
        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocation(new Point(250,250)); // set window location
        setResizable(false);
        
        
        //setLayout(new GridLayout(1,3));
        // Create a BorderLayout manager.
        setLayout(new BorderLayout());

        
        ActionButton_PlugBoard myButtons = new ActionButton_PlugBoard();
        add(myButtons, BorderLayout.EAST);
        TextField mytext = new TextField();
        add(mytext, BorderLayout.NORTH);
        Rotors myrotor = new Rotors();
        add(myrotor, BorderLayout.WEST);
        RotorStart mystart = new RotorStart();
        add(mystart, BorderLayout.SOUTH);
        TextScroll mytxt = new TextScroll();
        add(mytxt, BorderLayout.CENTER);

        pack();
        setSize(1000,700);
        setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        MyGUI mainMenu = new MyGUI();
    }
}
    

