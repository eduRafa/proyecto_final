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
import model.Images;

/**
 *
 * @author amgal
 */
public class Query {
    
    static Connection c=Connect.getMyConnection();
    static  ResultSet rs;
    
    /*
    *@return last: es un String que contiene el codigo de sospechoso del ultimo 
    registro introducido en la base de datos
    *Este metodo nos permite optener el codigo de sospechosos del utimo sospechosos 
    añadido a la base de datos 
    */
    private static String findLast(){
        String last=null;
        try {
            Statement s=c.createStatement();
            rs=s.executeQuery("SELECT CodeSuspect from SUSPECT");
            if(rs.last()){
                last=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last;
    }
    
    /*
    *Este metodo se encarga de almacenar en la base de datos una informacion dada de un atributo dado para un sospechosos en concreto
    *@param code: Es el codigo del sospechosos al que se le desean añadir los atributos
    *@param type: Es un String que es el tipo de atributo que se desea añadir
    *@param attribute: Es un string con el/los atributos que se dean añadir 
    */
    public static boolean addAtrivute(String code,String type, String attribute){
        boolean added=false;
        if(attribute!=null){
            try {
                String[] attibutes= attribute.split("$");
                Statement s=c.createStatement();
                switch(type){
                    case "phoneNumber":
                        for(int i=0;i<attibutes.length;i++){
                            s.executeUpdate("INSERT into PHONE (CodeSuspect,PhoneNumber)"
                            + "values ('"+code+"','"+attibutes[i]+"')");
                        }
                        break;
                    case "e_mail":
                        for(int i=0;i<attibutes.length;i++){
                            s.executeUpdate("INSERT into E-MAIL (CodeSuspect,Email)"
                            + "values ('"+code+"','"+attibutes[i]+"')");
                        }
                        break;
                    case "address":
                        for(int i=0;i<attibutes.length;i++){
                            s.executeUpdate("INSERT into ADDRESS (CodeSuspect,Address)"
                            + "values ('"+code+"','"+attibutes[i]+"')");
                        }
                        break;
                    case "companion":
                        for(int i=0;i<attibutes.length;i++){
                            s.executeUpdate("INSERT into COMPANIONS (CodeSuspect1,CodeSuspect2)"
                            + "values ('"+code+"','"+attibutes[i]+"')");
                        }
                        break;
                    case "carRegistration":
                        for(int i=0;i<attibutes.length;i++){
                            s.executeUpdate("INSERT into CAR_REGISTRATION (CodeSuspect,Resgistration_number)"
                            + "values ('"+code+"','"+attibutes[i]+"')");
                        }
                        break;
                }
                added=true;
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return added;
    }
    /*
    *@param img: Es un array de las imagenes de las que se quiere guardar la informacion
    */
    public static boolean addImage(Images[] img){
        /*boolean added=false;
        try {
            Statement s=c.createStatement();
            for(int i=0;i<img.length;i++){
                s.executeUpdate("INSERT into IMAGES (CodeSuspect,Image,Description)"
                + "values ('"+img[i].getCode+"','"+img[i].getImage+"'.'"+img[i].getDescription+"')");
            }
            added=true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return true;
    }
    /*
    *Este metodo permite añadir un sospechoso desde cero, pudiendo recibir campos nulos en aquellos que puedan serlo en la base de datos
    *@param attributes: Es un array con los atributos del sospechosos, puede tener campos null que seran guardados asi en la base de datos, 
    ademas debe de estar guardado en el orden (nombre,primer apellido, segundo apellido,numero(s) de telefono,direcion(es) de correo elctronico,
    direcion(es),compañero(s),matricula(s),imagen(s)
    */
    public static boolean addSuspect(){
        boolean correct=false;
        
        try {
            Connect.startConnection();
            c=Connect.getMyConnection();
            Statement s=c.createStatement();
            String[] attributes=new String[11];
            attributes[0]="Carlos";
            attributes[1]="Martinez";
            attributes[2]="Villamandos";
            attributes[3]="897987987";
            s.executeUpdate("INSERT INTO SUSPECT (name,lastname1, lastname2, Record,Facts)"
            + "values ('"+attributes[0]+"','"+attributes[1]+"','"+attributes[2]+"','"+attributes[8]+"','"+attributes[9]+"')");
            
            String last=findLast();
            correct=addAtrivute(last,"phoneNumber",attributes[3]);
            correct=addAtrivute(last,"e_mail",attributes[4]);
            correct=addAtrivute(last,"address",attributes[5]);
            correct=addAtrivute(last,"companion",attributes[6]);
            correct=addAtrivute(last,"carRegistration",attributes[7]);
            correct=addAtrivute(last,"image",attributes[10]);
            Connect.closeConnection();
         
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
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
                            + "from Suspect sus, PHONE p, E_Mail em,ADDRESS ad,CAR_REGISTRATION cr");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    /*
    *@param code: El codigo de sospechoso del que se desean las fotos
    *@return rs: es el resulset el cual contiene las fotografias del sospechosos junto a su descripcion
    */
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
                            + "from Suspect sus, PHONE p, E_Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus."+key+"="+value);
                    break;
                case "PhoneNumber":
                    
                    rs =s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E_Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus.CodeSuspect=(select CodeSuspect from PHONE where "+key+"="+value+")");
                    break;
                case "Email":
                    rs=s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E_Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus.CodeSuspect=(select CodeSuspect from EXISTS_ADDRESS where "+key+"="+value+")");
                    break;
                case "Resgistration_number":
                    rs=s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E_Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus.CodeSuspect=(select CodeSuspect from CAR_REGISTRATION where "+key+"="+value+")");
                    break;
                case "CodeSuspect":
                    rs=s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number"
                            + "from Suspect sus, PHONE p, E_Mail em,ADDRESS ad,CAR_REGISTRATION cr"
                            + "where sus.CodeSuspect="+value);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
