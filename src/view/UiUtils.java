/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rafa0
 */
public class UiUtils {

    /**
     * 
     * @param c Objeto contenedor de componentes.
     * @return Devuelve un ArrayList con todos los componentes desde el 
     * contenedor hasta el ultimo de sus componentes internos.
     */
    public static ArrayList<Component> getAllComponents(Container c) {
        Component[] comps = c.getComponents();
        ArrayList<Component> compList = new ArrayList<>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container) {
                compList.addAll(getAllComponents((Container) comp));
            }
        }
        return compList;
    }

    
    /** Metodo encargado de transformar texto en TextArea en un ArrayList
     * separando por intros cada valor.
     * @param allTheValues Todos los posibles valores del TextArea
     * @return ArrayList con valores separados por intros.
     */
    public static ArrayList<?> transformTextToArrayList(String allTheValues) {
        String[] eachValue = allTheValues.split(".+\\n");
        ArrayList<String> myValues;
        myValues = new ArrayList<>(Arrays.asList(eachValue));
        return myValues;
    }

}
