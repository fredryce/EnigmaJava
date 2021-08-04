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
import static pax2.part.pkg2.Rotors.rotorChoice;

/**
 *
 * @author Fred
 */
public class RotorStart extends JPanel implements FocusListener{  // this class responsible for setting the start position of the 3 rotors
    JComboBox inner1, inner2, inner3;
    JLabel innerName, middleName, outterName;
    static int[] rotorStart = {0,0,0}; //keeps the rotor start position inside of the array as integers
    String[] options = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"};
    public RotorStart(){
        setLayout(new GridLayout(2, 3, 10, 2));
        innerName = new JLabel("InnerRotor Starting");
        middleName = new JLabel("MiddleRotor Starting");
        outterName = new JLabel("OutterRotor Starting");
        inner1 = new JComboBox(options);                    //create 3 combo boxes for rotor starting choice
        inner2 = new JComboBox(options);
        inner3 = new JComboBox(options);
        inner1.setSelectedIndex(0);
        inner2.setSelectedIndex(0);
        inner3.setSelectedIndex(0);
        inner1.addFocusListener(this);
        add(innerName);
        add(middleName);
        add(outterName);
        
        add(inner1);
        inner2.addFocusListener(this);
        add(inner2);
        inner3.addFocusListener(this);
        add(inner3);
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {           // when focus lost set the rotor position and put them inside an array
        if(e.getSource() == inner1){
            rotorStart[0] = inner1.getSelectedIndex();
            
        }
        else if(e.getSource() == inner2)
        {
            rotorStart[1] = inner2.getSelectedIndex();
        }
        else if(e.getSource() == inner3){
            rotorStart[2] = inner3.getSelectedIndex();
        }
        
    }
    
}
