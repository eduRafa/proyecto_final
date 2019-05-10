/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Query;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Communication;
import view.UI;
import view.uiUtils;

/**
 *
 * @author rafa0
 */
public class Controller implements ActionListener {

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

    public Color getPrimaryColor() {
        return Communication.getPrimaryColor();
    }

    public void setPrimaryColor(Color c) {
        Communication.setPrimaryColor(c);
        uiUtils.printAllComponents(myUI, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Anadir sospechoso":
                addSuspect();
                ;
                break;
            case "remove":
                ;
                break;

        }
    }

    private void addSuspect() {
        //String[][] data=myUI.getAddTableValues();
        //Query.addSuspect(data);
    }
    
    public static /*String[]*/void getPhotos(String idSuspect) {
        //Query.getPhotos(idSuspect);
    }

}
