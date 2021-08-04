/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pax2.part.pkg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Fred
 */
public class TextField extends JPanel implements FocusListener{
    JTextField text;
    static String input;
    public TextField(){
        text = new JTextField("Enter Text Here...........", 80);
        text.addFocusListener(this);
        add(text);
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        text.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        input = text.getText();
    }

  
    
    
}
