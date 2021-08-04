/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Pax2Part2 extends JFrame{
    

    /**
     * @param args the command line arguments
     */
    public Pax2Part2(){
        setTitle("Main Menu");
        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocation(new Point(250,250)); // set window location
        setResizable(false);
        
        
        //setLayout(new GridLayout(1,3));
        // Create a BorderLayout manager.
        setLayout(new BorderLayout());

        
        MainPanel myButtons = new MainPanel();
        add(myButtons, BorderLayout.EAST);
        TextField mytext = new TextField();
        add(mytext, BorderLayout.NORTH);
        Rotors myrotor = new Rotors();
        add(myrotor, BorderLayout.WEST);
        RotorStart mystart = new RotorStart();
        add(mystart, BorderLayout.SOUTH);

        pack();
        setSize(1000,700);
        setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Pax2Part2 mainMenu = new Pax2Part2();
    }
}
    

