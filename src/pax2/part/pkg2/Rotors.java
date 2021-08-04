/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pax2.part.pkg2;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Fred
 */
public class Rotors extends JPanel implements FocusListener{
    static int[] rotorChoice = {0, 1, 2};
    JComboBox rotor1, rotor2, rotor3;
    JLabel r1name, r2name, r3name;
    String[] options = {"Rotor1", "Rotor2", "Rotor3", "Rotor4", "Rotor5"};
    Rotors(){
        setLayout(new GridLayout(3,3, 10, 10));
        
        r1name = new JLabel("Inner");
        r2name = new JLabel("Middle");
        r3name = new JLabel("Outter");
        rotor1 = new JComboBox(options);
        rotor2 = new JComboBox(options);
        rotor3 = new JComboBox(options);
        rotor1.setSelectedIndex(0);
        rotor2.setSelectedIndex(1);
        rotor3.setSelectedIndex(2);
       
        add(r1name);
        rotor1.addFocusListener(this);
        add(rotor1);
        add(r2name);
        rotor2.addFocusListener(this);
        add(rotor2);
        add(r3name);
        rotor3.addFocusListener(this);
        add(rotor3);
        
        
        
    }

    @Override
    public void focusGained(FocusEvent e) {
//        if(e.getSource() == rotor1){
//            rotorChoice[0] = rotor1.getSelectedIndex();
//            System.out.println("Inner is:" + rotor1.getSelectedIndex());
//        }
//        else if(e.getSource() == rotor2)
//        {
//            rotorChoice[1] = rotor2.getSelectedIndex();
//        }
//        else if(e.getSource() == rotor3){
//            rotorChoice[2] = rotor3.getSelectedIndex();
//        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == rotor1){
            rotorChoice[0] = rotor1.getSelectedIndex();
            
        }
        else if(e.getSource() == rotor2)
        {
            rotorChoice[1] = rotor2.getSelectedIndex();
        }
        else if(e.getSource() == rotor3){
            rotorChoice[2] = rotor3.getSelectedIndex();
        }
       
    }
    
}
