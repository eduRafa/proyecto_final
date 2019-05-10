/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rafa0
 */
public class Utils {
    
    
    
    
    public static Image[] decodeImage(ResultSet images) throws SQLException{
        Blob photo;
        String desc;
        String suspect;
        ArrayList<Image> myImages=new ArrayList<>();
        
        if(images.next()){
            photo=images.getBlob(1);
            desc=images.getString(2);
            suspect=images.getString(3);
            myImages.add(photo,desc,suspect);
        }
        
        return myImages.toArray();
        
    }
}
