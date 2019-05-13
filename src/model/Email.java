/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author usuario
 */
public class Email {
    String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
    Pattern pattern = Pattern.compile(emailPattern);
    private int CodeEmail;
    private int CodeSuspect;
    private String Email;
    
    public Email(int CodeEmail, int CodeSuspect, String Email){
        super();
        this.CodeEmail=CodeEmail;
        this.CodeSuspect=CodeSuspect;
        if (Email != null) {
            Matcher matcher = pattern.matcher(Email);
            if (matcher.matches()) {
                this.Email=Email;
            }
        }
    }
     public int getCodeEmail(){
        return CodeEmail;
    }
    
    public void setCodeEmail(int CodeEmail){
        this.CodeEmail=CodeEmail;
    }
    
     public int getCodeSuspect(){
        return CodeSuspect;
    }
    
    public void setCodeSuspect(int CodeSuspect){
        this.CodeSuspect=CodeSuspect;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setEmail(String Email){
        if (Email != null) {
            Matcher matcher = pattern.matcher(Email);
            if (matcher.matches()) {
                this.Email=Email;
            }
        }
    }
    
}
