package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Jurad0
 */
public class Car_Registration {  
    private String registration;
    
    
public Car_Registration(String registration) {
    this.registration=registration;
    
}

<<<<<<< HEAD
=======
public boolean validate (String registration){
    boolean validate=false;    
    Pattern p = Pattern.compile("^[0-9]{4}[a-zA-Z]{3}$");
    Matcher m = p.matcher(this.registration);
    if (m.find()){}
    
        return true;
}
>>>>>>> f526a2cd25aea849a915f210a056e774f727b507

public String getRegistration(){
        return registration;
    }
    
    public void setRegistration(String registration){
        this.registration=registration;
    }
    
    

   
}
