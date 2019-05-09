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
public class Companions {
    private int CodeSuspect1;
    private int CodeSuspect2;
    
    public Companions(int CodeSuspect1, int CodeSuspect2){
        super();
        this.CodeSuspect1=CodeSuspect1;
        this.CodeSuspect2=CodeSuspect2;
    }
    
     public int getCodeSuspect1(){
        return CodeSuspect1;
    }
    
    public void setCodeSuspect1(int CodeSuspect1){
        this.CodeSuspect1=CodeSuspect1;
    }
    
     public int getCodeSuspect2(){
        return CodeSuspect2;
    }
    
    public void setCodeSuspect2(int CodeSuspect2){
        this.CodeSuspect2=CodeSuspect2;
    }
}
