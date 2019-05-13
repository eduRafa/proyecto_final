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
    public String registration;
    
    
public Car_Registration(String registration) {
    this.registration=registration;
    
}

public boolean validate (String registration){
    boolean validate=false;
<<<<<<< HEAD
    Pattern p = Pattern.compile("^[0-9]{4}[a-zA-Z]{3}$");
=======
    Pattern p = Pattern.compile("[0-9]{4}[a-zA-Z]{3}$");
>>>>>>> 2fb12bb2416184de0df26c2f2dc752a3c4d28b9c
    Matcher m = p.matcher(this.registration);
    if (m.find())
       validate=true;
        return validate;
       
}
    
    

   
}
