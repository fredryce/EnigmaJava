/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pax2.part.pkg2;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author xwang2945
 */
public class MainPanel extends JPanel implements ActionListener{
    JButton encodeButton;
    JButton decodeButton;
    JLabel myLabel, myLabel1;
    String[] choices = new String[20];
    String[] options = {"Select", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    JComboBox[] comboboxes = new JComboBox[20];
    String stringMessage;
    int[] pegboard = new int[26];
    public MainPanel(){
        setLayout(new GridLayout(12, 2, 5, 10));
       
        encodeButton = new JButton("Encode");
        decodeButton = new JButton("Decode");
        myLabel = new JLabel("PLUGBoard");
        myLabel1 = new JLabel("Settings");
        add(myLabel);
        add(myLabel1);
       
        for(int i = 0; i < comboboxes.length; i++){
            comboboxes[i] = new JComboBox(options);
            comboboxes[i].setSelectedIndex(0);
            add(comboboxes[i]);
        }
        
        
        encodeButton.addActionListener(this);
        decodeButton.addActionListener(this);
        
        add(encodeButton);
        add(decodeButton);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Encode")){
            System.out.println(TextField.input);
            for(int i = 0; i < RotorStart.rotorStart.length; i++){
                System.out.println(RotorStart.rotorStart[i]);
            }
            setPeg();
            Cipher myCipher = new Cipher(pegboard, TextField.input, Rotors.rotorChoice, RotorStart.rotorStart);
            System.out.println("innerR key is: " + myCipher.innerR);
            System.out.println("MiddleR key is: " + myCipher.middleR);
            System.out.println("OutterR key is: " + myCipher.outterR);
            System.out.println("The enCoded Char is: " + myCipher.encoding(TextField.input));
            
            
            
            
        }
        else if(e.getActionCommand().equals("Decode")){
            
        }
    }
    public void setPeg(){
        for(int i = 0; i < pegboard.length; i++){
                pegboard[i] = -1;    
        }
        for(int j = 0; j < comboboxes.length ; j+= 2){
           
            int number = (int)comboboxes[j].getSelectedItem().toString().charAt(0) - 65;
            //System.out.println(number);
            int next = (int)comboboxes[j+1].getSelectedItem().toString().charAt(0) - 65;
            //System.out.println(next);
            pegboard[number] = next;
            pegboard[next] = number;
        }
        
    }
    
    
}
