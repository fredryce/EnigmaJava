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
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Fred
 */
public class TextField extends JPanel implements FocusListener, ActionListener{  // this class responsible for the upper panel with the text field and the browse button.
    static boolean fileReading = false;
    JTextField text;
    JFileChooser jfc;
    JButton jbc;
    File file;
    static String input;
    static BufferedReader myBR;
    public TextField(){
        text = new JTextField("Enter In String oR click Browse for File", 80);
        jbc = new JButton("Browse");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "Text");
        jfc = new JFileChooser();
        jfc.setFileFilter(filter);
        text.addFocusListener(this);
        jbc.addActionListener(this);
        add(text);
        add(jbc);
       
        
    }

    @Override
    public void focusGained(FocusEvent e) { //does nothing when focus gained
        
    }

    @Override
    public void focusLost(FocusEvent e) { //return data when focus lost
        input = text.getText();
    }
    public void actionPerformed(ActionEvent e){  //action button that gets the file the user choses
        int filechooser = jfc.showOpenDialog(null);
        if(filechooser == JFileChooser.APPROVE_OPTION){
            file = jfc.getSelectedFile();
            Path myPath = file.toPath();
            
            text.setText(file.toString());
            fileReading = true;
            try{
                myBR = Files.newBufferedReader(myPath);
                
            }
            catch(Exception p){
                p.printStackTrace();
                
            }
            
            
        }
        
    }

  
    
    
}
