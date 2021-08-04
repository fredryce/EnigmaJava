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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author xwang2945
 */
public class ActionButton_PlugBoard extends JPanel implements ActionListener{
    JButton encodeButton;
    JButton decodeButton;
    JLabel myLabel, myLabel1;
    String[] choices = new String[20];
    String[] options = {"Select", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    JComboBox[] comboboxes = new JComboBox[20];  //plugBoard array, 20 comboboxes 
    String stringMessage;
    int[] pegboard = new int[26];  //array storing the plugBoard setting. 0 index = A, and 25 = Z
    public ActionButton_PlugBoard(){
        setLayout(new GridLayout(12, 2, 5, 10));
       
        encodeButton = new JButton("Encode");
        decodeButton = new JButton("Decode");
        myLabel = new JLabel("PLUGBoard");
        myLabel1 = new JLabel("Settings");
        add(myLabel);
        add(myLabel1);
       
        for(int i = 0; i < comboboxes.length; i++){     //setting and adding all the comboBoxes
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
        if(e.getActionCommand().equals("Encode")){         //If encode is pressed
//            System.out.println(TextField.input);
//            for(int i = 0; i < RotorStart.rotorStart.length; i++){
//                System.out.println(RotorStart.rotorStart[i]);
//            }
            setPeg(); //get the pegBoard setting and set the pegBoard array
            Cipher myCipher = new Cipher(pegboard, TextField.input, Rotors.rotorChoice, RotorStart.rotorStart); //call the contructor for cipher class passin in all the informations 
//            System.out.println("innerR key is:  " + myCipher.innerR);
//            System.out.println("MiddleR key is: " + myCipher.middleR);
//            System.out.println("OutterR key is: " + myCipher.outterR);
            if (TextField.fileReading == false) {       //if no file chosen only encode the string in the text field
                String message = myCipher.encoding(TextField.input, true);
                System.out.println(message);
                JOptionPane.showMessageDialog(null,message, "Encoded Message", JOptionPane.INFORMATION_MESSAGE );
                
            }
            else{  // else encode the file
                myCipher.encodeFile();
                
            }
            
            
            
            
        }
        else if(e.getActionCommand().equals("Decode")){         // same for decoding.
            setPeg();
            Cipher myCipher = new Cipher(pegboard, TextField.input, Rotors.rotorChoice, RotorStart.rotorStart);
            if(TextField.fileReading == false){
            String message = myCipher.encoding(TextField.input, false);
            System.out.println(message);
            JOptionPane.showMessageDialog(null,message, "Decoded Message", JOptionPane.INFORMATION_MESSAGE );
            }
            else{
                myCipher.decodeFile();
            }
            
        }
    }
    public void setPeg(){   // setting up the pegBoard the index swop with the corresponding element number. 
        for(int i = 0; i < pegboard.length; i++){
                pegboard[i] = -1;    
        }
        for(int j = 0; j < comboboxes.length ; j+= 2){
            if(!comboboxes[j].getSelectedItem().equals("Select") && !comboboxes[j+1].getSelectedItem().equals("Select")){
           
            int number = (int)comboboxes[j].getSelectedItem().toString().charAt(0) - 65;
            //System.out.println(number);
            int next = (int)comboboxes[j+1].getSelectedItem().toString().charAt(0) - 65;
            //System.out.println(next);
            pegboard[number] = next;
            pegboard[next] = number;
            }
        }
//        for(int k = 0; k < pegboard.length; k++){
//            System.out.print(pegboard[k]);
//            
//        }
        
    }
    
    
}
