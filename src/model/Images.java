/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author Antonio Jose Adamuz Sereno
 */
public class Images {
    private Blob Image;
    private int CodeImage;
    private Blob Description;
    private int CodeSuspect;
    
    public Images(Blob Image, int CodeImage, Blob Description,
            int CodeSuspect){
            super();
            this.Image=Image;
            this.CodeImage=CodeImage;
            this.Description=Description;
            this.CodeSuspect=CodeSuspect;
            
    }
    
    public Blob getImage(){
        return Image;
    }
    
    public void setImage(Blob Image){
        this.Image=Image;
    }
    
    public int getCodeImage(){
        return CodeImage;
    }
    
    public void setCodeImage(int CodeImage){
        this.CodeImage=CodeImage;
    }
    
    public Blob getDescription(){
        return Description;
    }
    
    public void setDescription(Blob Description){
        this.Description=Description;
    }
    
    public int getCodeSuspect(){
        return CodeSuspect;
    }
    
    public void setCodeSuspect(int CodeSuspect){
        this.CodeSuspect=CodeSuspect;
    }
}
