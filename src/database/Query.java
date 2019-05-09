/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amgal
 */
public class Query {
    
    static Connection c=Connect.getMyConnection();
    static  ResultSet rs;
    
    public static boolean addSuspect(String[] attributes){
        boolean correct=false;
        String nombre;
        String apellido1;
        String apellido2;
        String Telefono;
        String correo;
        String direcciones;
        String acompañantes;
        String matriculas;
        String antecedentes;
        String hechos;
        String image;
        try {
            Statement s=c.createStatement();
            rs=s.executeQuery("INSERT ")
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return correct;
    }
    
    /*
    * Este metodo realiza una consulta a la base de datos para mostrar todos los sospechosos guardados
    *@return rs: Es el resultset con la resuesta de la consulta al servidor, el cual contiene el registro co todos los sospechosos
    */
    public static ResultSet showAll(){
        try {
            Statement s=c.createStatement();
            rs=s.executeQuery("Select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    public static ResultSet showImg(String code){
        try {
            Statement s=c.createStatement();
            rs=s.executeQuery("SELECT Image, Description FROM IMAGES"
                    + "where CodeSuspect="+code);
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
            
    /*
    *Este metode permite realizar una consulta en la base de datos buscando con por un valor dado de un paramatro concreto
    *@param key: Es tipo de campo por el cual se esta buscando 
    *@param value: Es el valor por el que se realiza la busqueda
    *@return rs: Es el resultset que guarda el resultado de la consulta
    */
    public static ResultSet searchBy(String key,String value){
        try {
            Statement s=c.createStatement();
            switch(key){
                case "name":
                case "lastname1":
                case "lastname2":
                    rs =s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus."+key+"="+value);
                    break;
                case "PhoneNumber":
                    
                    rs =s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus.CodeSuspect=(select CodeSuspect from PHONE where "+key+"="+value+")");
                    break;
                case "Email":
                    rs=s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus.CodeSuspect=(select CodeSuspect from EXISTS_ADDRESS where "+key+"="+value+")");
                    break;
                case "Resgistration_number":
                    rs=s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus.CodeSuspect=(select CodeSuspect from CAR_REGISTRATION where "+key+"="+value+")");
                    break;
                case "CodeSuspect":
                    rs=s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus.CodeSuspect="+value);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
