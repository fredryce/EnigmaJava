/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pax2.part.pkg2;

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

    


    public Cipher(int[] plug, String message, int[] rotorChoice, int[] startingPosition) {
        this.plug = plug;
        innerR = stringArray[rotorChoice[0]];  //String Inner
        System.out.println("Start position for Inner is: " + innerR);
        middleR = stringArray[rotorChoice[1]]; //string middle
        System.out.println("Start position for Inner is: " + middleR);
        outterR = stringArray[rotorChoice[2]]; //string outter
        System.out.println("Start position for Inner is: " + outterR);
        
        innerR = setOrigin(startingPosition[0], innerR);
        middleR = setOrigin(startingPosition[1], middleR);
        outterR = setOrigin(startingPosition[2], outterR);
    }
    public String encoding(String myString){
        
        String stringForm = "";
        
        
        for(int i = 0; i < myString.length(); i++){
            char character = encodeChar(myString.charAt(i));
            stringForm  += character;
        }
        return stringForm;
       
    }
   
    public char encodeChar(char mychar){
        if (Character.isLetter(mychar)) {
            mychar = Character.toUpperCase(mychar);
            if (plug[(int) mychar - 65] != -1) {
                int charASCII = plug[(int) mychar - 65];
                mychar = (char) ( charASCII + 65);
            } 
            

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
    
    
    
}
//JScrollPane, JFileChooser
//ABCDEFGHIJKLMNOPQRSTUVWXY Z