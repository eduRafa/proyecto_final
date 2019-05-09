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
    
    public static ResultSet searchBy(String key,String value){
        try {
            Statement s=c.createStatement();
            switch(key){
                case "name":
                case "lastname1":
                case "lastname2":
                    rs =s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number,im.Image,im.Description"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr,IMAGES im"
                            + "where sus."+key+"="+value);
                    break;
                case "PhoneNumber":
                    rs =s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number,im.Image,im.Description"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr,IMAGES im"
                            + "where sus.CodeSuspect=(select CodeSuspect from PHONE where "+key+"="+value+")");
                    break;
                case "Email":
                    rs=s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number,im.Image,im.Description"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr,IMAGES im"
                            + "where sus.CodeSuspect=(select CodeSuspect from EXISTS_ADDRESS where "+key+"="+value+")");
                    break;
                case "Resgistration_number":
                    rs=s.executeQuery("select sus.name,sus.lastname1,sus.lastname2,sus.Record,sus.Facts,"
                            + "p.PhoneNumber, em.Email,ad.Address,cr.Resgistration_number,im.Image,im.Description"
                            + "from Suspect sus, PHONE p, E-Mail em,ADDRESS ad,CAR_REGISTRATION cr,IMAGES im"
                            + "where sus.CodeSuspect=(select CodeSuspect from CAR_REGISTRATION where "+key+"="+value+")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
