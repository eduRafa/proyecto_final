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
public class Address {
    private int CodeAddress;
    private int CodeSuspect;
    private String Address;
    
    public Address(int CodeAddress, int CodeSuspect, String Address){
        super();
        this.CodeAddress=CodeAddress;
        this.CodeSuspect=CodeSuspect;
        this.Address=Address;
        
    }
    
    public int getCodeAddress(){
        return CodeAddress;
    }
    
    public void setCodeAddress(int CodeAddress){
        this.CodeAddress=CodeAddress;
    }
    
    public int getCodeSuspect(){
        return CodeSuspect;
    }
    
    public void setCodeSuspect(int CodeSuspect){
        this.CodeSuspect=CodeSuspect;
    }
    
    public String getAddress(){
        return Address;
    }
    
    public void setAddress(String Address){
        this.Address= Address;
    }
}
