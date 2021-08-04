/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pax2.part.pkg2;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author xwang2945
 */
public class TextScroll extends JPanel{   //this classs put the picture on the main frame
    ImageIcon myimage;
    //JScrollPane jsp;
    JLabel jL;
    TextScroll(){
        myimage = new ImageIcon("LOLZ2.jpg");
        
        jL = new JLabel(myimage);
        setLayout(new GridLayout());
        add(jL);
        
    }
  
    
    
}
