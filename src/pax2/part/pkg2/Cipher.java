/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pax2.part.pkg2;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Fred
 */
public class Cipher {
    private final String rotor1 = "GNUAHOVBIPWCJQXDKRY ELSZFMT";
    private final String rotor2 = "EJ OTYCHMRWAFKPUZDINSXBGLQV";
    private final String rotor3 = "BDFHJLNPRTVXZACEGI KMOQSUWY";
    private final String rotor4 = "KPHDEAC VTWQMYNLXSURZOJFBGI";
    private final String rotor5 = "NDYGLQICVEZRPTAOXWBMJSUHK F";
    private String[] stringArray = {rotor1, rotor2, rotor3, rotor4, rotor5};
    String innerR, middleR, outterR;
    int[] plug; //0 index is A and 25 index is z, if element = -1 means no plug setting
    String message;
    int[] rotorChoice; //consist of 0, 1, 2 index. each index can go from 0-4 representing the 5 rotors.
    int[] startingPosition; //consist of 0,1,2 index, each index go from 0-26 representing starting posisition.
    private int innerRnum = 0; // number of rotations for innerRnum
    private int middleRnum = 0; // number of rotations for middleRn
    private int outterRnum = 0; // number of rotation for outterRnum

    public Cipher() {
        
    }

    


    public Cipher(int[] plug, String message, int[] rotorChoice, int[] startingPosition) {  //when the constructor is called, the 
        this.plug = plug;
        innerR = stringArray[rotorChoice[0]];  //String Inner
        //System.out.println("Start position for Inner is: " + innerR);
        middleR = stringArray[rotorChoice[1]]; //string middle
        //System.out.println("Start position for Inner is: " + middleR);
        outterR = stringArray[rotorChoice[2]]; //string outter
        //System.out.println("Start position for Inner is: " + outterR);
        
        innerR = setOrigin(startingPosition[0], innerR);
        middleR = setOrigin(startingPosition[1], middleR);
        outterR = setOrigin(startingPosition[2], outterR);
    }
    public String encoding(String myString, boolean encode){
        char character = ' ';
        String stringForm = "";
        
        
        for(int i = 0; i < myString.length(); i++){
            if(encode){
            character = encodeChar(myString.charAt(i));
            }
            else if(!encode){
            character = decodeChar(myString.charAt(i));
            }
            stringForm  += character;
        }
        return stringForm;
       
    }
    public char encodeChar(char mychar){
        boolean isLower = false;
        int index = 0;
        if (Character.isLetter(mychar) || mychar == ' ') {
            if(Character.isLowerCase(mychar)){
                isLower = true;
            }
            mychar = Character.toUpperCase(mychar);
            if (mychar != ' ' && plug[(int) mychar - 65] != -1) {
                int charASCII = plug[(int) mychar - 65];
                mychar = (char) ( charASCII + 65);
            } 
            for(int i = 0; i < innerR.length(); i++){
                if(mychar == innerR.charAt(i)){
                    index = i;
                    break;
                }
                
            }
            mychar = outterR.charAt(index);
            for(int j = 0; j < middleR.length(); j++){
                if(mychar == middleR.charAt(j)){
                    index = j;
                    break;
                }
            }
            mychar = outterR.charAt(index);
            if (mychar != ' ' && plug[(int) mychar - 65] != -1) {
                int charASCII = plug[(int) mychar - 65];
                mychar = (char) ( charASCII + 65);
            } 
            if(isLower == true){
                mychar = Character.toLowerCase(mychar);
            }
            shift();
            //System.out.println("New Inner Key is:  " + innerR + "index is " + innerRnum);
            //System.out.println("New midlde Key is: " + middleR + "index is " + middleRnum);
            //System.out.println("New outter Key is: " + outterR + "index is " + outterRnum);

        }
       
        return mychar;
        
    }
    public void encodeFile(){
        JFrame myframe = new JFrame();
        JTextArea myArea = new JTextArea();
        JScrollPane myScroll = new JScrollPane(myArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myArea.setEditable(false);
        myArea.setLineWrap(true);
        myArea.setWrapStyleWord(true);
        myframe.setTitle("ENCODED.......");
        
        myframe.add(myScroll);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        String line = null;
        try {
            while ((line = TextField.myBR.readLine()) != null) {
                myArea.append(encoding(line, true));
                //System.out.println(encoding(line, true));
                

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        myframe.setVisible(true);
        myframe.setSize(800, 1000);

    }
    public void decodeFile(){
        JFrame myframe = new JFrame();
        JTextArea myArea = new JTextArea();
        JScrollPane myScroll = new JScrollPane(myArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myArea.setEditable(false);
        myArea.setLineWrap(true);
        myArea.setWrapStyleWord(true);
        myframe.setTitle("DECODED.......");
        myframe.add(myScroll);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String line = null;
        try {
            while ((line = TextField.myBR.readLine()) != null) {
                //System.out.println(encoding(line, false));
                myArea.append(encoding(line, false));
                

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        myframe.setVisible(true);
        myframe.setSize(800, 1000);
        
        
    }
   
    public char decodeChar(char mychar){
        boolean isLower = false;
        int index = 0;
        if (Character.isLetter(mychar) || mychar == ' ') {
            if(Character.isLowerCase(mychar)){
                isLower = true;
            }
            mychar = Character.toUpperCase(mychar);
            if (mychar != ' ' && plug[(int) mychar - 65] != -1) {
                int charASCII = plug[(int) mychar - 65];
                mychar = (char) ( charASCII + 65);
            } 
            for(int i = 0; i < outterR.length(); i++){
                if(mychar == outterR.charAt(i)){
                    index = i;
                    break;
                }
                
            }
            mychar = middleR.charAt(index);
            for(int j = 0; j < outterR.length(); j++){
                if(mychar == outterR.charAt(j)){
                    index = j;
                    break;
                }
            }
            mychar = innerR.charAt(index);
            if (mychar != ' ' && plug[(int) mychar - 65] != -1) {
                int charASCII = plug[(int) mychar - 65];
                mychar = (char) ( charASCII + 65);
            }
            if(isLower == true){
                mychar = Character.toLowerCase(mychar);
            }
            shift();
            //System.out.println("New Inner Key is:  " + innerR + "index is " + innerRnum);
            //System.out.println("New midlde Key is: " + middleR + "index is " + middleRnum);
            //System.out.println("New outter Key is: " + outterR + "index is " + outterRnum);

        }
       
        return mychar;
        
    }
    public String setOrigin(int start, String wheels){
        
        for(int i = 0; i < start; i ++){
            wheels = rotate(wheels);
             
        }
        return wheels;
        
    }
    public String rotate(String string){
        char keyZero = string.charAt(0);
        string = string.substring(1);
        return string + keyZero;
        
    }
    public String counterRotate(String string){
        char keyLast = string.charAt(string.length() - 1);
        string = string.substring(0, string.length() - 1);
        return keyLast + string;
    }
    public void shift(){
        if(innerRnum < 26){
            innerR = counterRotate(innerR);
            innerRnum++;
        }
        else if(innerRnum == 26){
            innerR = counterRotate(innerR);
            innerRnum = 0;
            if(middleRnum < 26){
                middleR = counterRotate(middleR);
                middleRnum++;
            }
            else if(middleRnum == 26){
                middleR = counterRotate(middleR);
                middleRnum = 0;
                outterR = counterRotate(outterR);
            }
        }
    }
    
    
    
}
//JScrollPane, JFileChooser
//ABCDEFGHIJKLMNOPQRSTUVWXY Z