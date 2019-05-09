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
public class Suspect {
    
    private int CodeSuspect;
    private String name;
    private String lastname1;
    private String lastname2;
    private int CCompanions;
    private String Record;
    private String Facts;
    
    public Suspect(int CodeSuspect, String name, String lastname1,
            String lastname2, int CCompanions, String Record, String Facts){
            super();
            this.CodeSuspect=CodeSuspect;
            this.name=name;
            this.lastname1=lastname1;
            this.lastname2=lastname2;
            this.CCompanions=CCompanions;
            this.Record=Record;
            this.Facts=Facts;
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
    
    
    
    
    
}
