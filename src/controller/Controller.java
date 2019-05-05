/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import model.Communication;
import view.UI;

/**
 *
 * @author rafa0
 */
public class Controller {

    private static UI myUI;
    private static Controller me;

    private Controller() {

    }

    public static Controller getInstance() {
        if (me == null) {
            me = new Controller();
            return me;
        } else {
            return me;
        }
    }

    public static void setUi(UI ui) {
        myUI = ui;
        myUI.setController(me);
    }
    
    public Color getPrimaryColor(){
        return Communication.getPrimaryColor();
    }
    
    public void setPrimaryColor(Color c){
        Communication.setPrimaryColor(c);
    }
}
