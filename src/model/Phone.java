/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Antonio Jose Adamuz Sereno
 */
public class Phone {
    private int CodeSuspect;
    private int CodePhone;
    private int PhoneNumber;
    
    public Phone(int CodeSuspect, int CodePhone, int PhoneNumber){
        super();
        this.CodeSuspect=CodeSuspect;
        this.CodePhone=CodePhone;
        this.PhoneNumber=PhoneNumber;
    }
    
    public int getCodeSuspect(){
        return CodeSuspect;
    }
    
    public void setCodeSuspect(int CodeSuspect){
        this.CodeSuspect=CodeSuspect;
    }
    
    public int getCodePhone(){
        return CodePhone;
    }
    
    public void setCodePhone(int CodePhone){
        this.CodePhone=CodePhone;
    }
    
    public int getPhoneNumber(){
        return PhoneNumber;
    }
    
    public void setPhoneNumber(int PhoneNumber){
        this.PhoneNumber=PhoneNumber;
    }
}
