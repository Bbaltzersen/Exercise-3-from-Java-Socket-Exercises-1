/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise3;

/**
 *
 * @author bbalt
 */
public class Protocol {
 
    
    
    public String checkPro(String word) {
        if(word.contains("UPPER#") == true) {
            return upperWord(word);
        }
        if(word.contains("LOWER#") == true ) {
            return lowerWord(word);
        }
        if(word.contains("REVERSE#") == true) {
            return reverseWord(word);
        }
        if(word.contains("TRANSLATE#") == true) {
            return translateWord(word);
        }
        else {
            return "false";
        }
    }
    
    public String upperWord(String word) {
        String cha = word.toUpperCase();
        return cha.replace("UPPER#", "");
    }
    
    public String lowerWord(String word) {
        String cha = word.toLowerCase();
        return cha.replace("lower#", "");
    }
    
    public String reverseWord(String word) {
        String noRev = word.replace("REVERSE#", "");
        String rev = new StringBuffer(noRev).reverse().toString();
        String upRev = Character.toUpperCase(rev.charAt(0)) + rev.substring(1);
        return upRev;
    }
    
    public String translateWord(String word) {
        if(word.replace("TRANSLATE#", "").equals("dog")) {
            return "hund";
        }
        else {
            return "#NOT_FOUND";
        }
    }
}
