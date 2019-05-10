/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;



/**
 *
 * @author Antonio Jose Adamuz Sereno
 */
public class Suspect {
    
    private int CodeSuspect;
    private String name;
    private String lastname1;
    private String lastname2;
    private int CCompanions;
    private String Record;
    private String Facts;
    private ArrayList<Phone> Phone = new ArrayList<Phone>();
    private ArrayList<Email> Email= new ArrayList<Email>();
    private ArrayList<Address> Address= new ArrayList<Address>();
    private ArrayList<Car_Registration> Car_registration=
            new ArrayList<Car_Registration>();
    
   
    
    public Suspect(int CodeSuspect, String name, String lastname1,
            String lastname2, int CCompanions, String Record, String Facts,
            ArrayList Phone, ArrayList Email, ArrayList Address,
            ArrayList Car_registration){
            super();
            this.CodeSuspect=CodeSuspect;
            this.name=name;
            this.lastname1=lastname1;
            this.lastname2=lastname2;
            this.CCompanions=CCompanions;
            this.Record=Record;
            this.Facts=Facts;
            this.Phone=Phone;
            this.Email=Email;
            this.Address=Address;
            this.Car_registration=Car_registration;
           
            
    }
    
    public int getCodeSuspect(){
        return CodeSuspect;
    }
    
    public void setCodeSuspect(int CodeSuspect){
        this.CodeSuspect=CodeSuspect;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
     public String getLastname1(){
        return lastname1;
    }
    
    public void setLastname1(String lastname1){
        this.lastname1=lastname1;
    }
    
    public String getLastname2(){
        return lastname2;
    }
    
    public void setLastname2(String lastname2){
        this.lastname2=lastname2;
    }
    
    public int getCCompanions(){
        return CCompanions;
    }
    
    public void setCCompanions(int CCompanions){
        this.CCompanions=CCompanions;
    }
    
    public String getRecord(){
        return Record;
    }
    
    public void setRecord(String Record){
        this.Record=Record;
    }
    
    public String getFacts(){
        return Facts;
    }
    
    public void setFacts(String Facts){
        this.Facts=Facts;
    }
    
    public ArrayList getPhone(){
        return Phone;
    }
    
    public void setPhone(ArrayList Phone){
        this.Phone=Phone;
    }
    
    public ArrayList getEmail(){
        return Email;
    } 
    
    public void setEmail(ArrayList Email){
        this.Email=Email;
    }
    
    public ArrayList getAddress(){
        return Address;
    }
    
    public void setAddress(ArrayList Address){
        this.Address=Address;
    }
    
    public ArrayList getCar_Resgistration(){
        return Car_registration;
    }
    
    public void setCar_Registration(ArrayList Car_registration){
        this.Car_registration=Car_registration;
    }
   
    
    
}
