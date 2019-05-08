/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.util.Arrays;

/**
 *
 * @author rafa0
 */
public class uiUtils {

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

    public static void printAllComponents(Container con, Color col) {
        Component[] comps = con.getComponents();
        for (Component comp : comps) {
            if (comp.getAccessibleContext().getAccessibleName() != null && comp.
                    getAccessibleContext().getAccessibleName().contains("$")) {
                String[] value = comp.getAccessibleContext().getAccessibleName().split("\\$");
                if (comp instanceof JButton) {
                    JButton tmpButton = (JButton) comp;
                    applyBackgroundColor(comp, value[0], col);
                    applyButtonBorderColor(tmpButton, value[1], col);
                    applyForegroundColor(comp, value[2], col);
                    if (tmpButton.getIcon() != null) {
                        getNewIcon(tmpButton.getIcon());
                    }
                } else if (comp instanceof JLabel) {
                    JLabel tmpLabel = (JLabel) comp;
                    applyBackgroundColor(comp, value[0], col);
                    //applyButtonBorderColor((JButton)comp, value[1], col);
                    applyForegroundColor(comp, value[2], col);
                    if (tmpLabel.getIcon() != null) {
                        getNewIcon(tmpLabel.getIcon());
                    }
                } else if (comp instanceof JTable) {
                    applyBackgroundTableHeaderColor((JTable) comp, value[0], col);
                    applyBorderTableHeaderColor((JTable) comp, value[1], col);
                    applyForegroundColor((JTable) comp, value[2], col);
                    ((JTable) comp).setSelectionBackground(col);
                } else if (comp instanceof JPanel) {
                    applyBackgroundPanelColor((JPanel) comp, value[0], col);
                    applyBorderPanelColor((JPanel) comp, value[1], col);
                    applyForegroundColor(comp, value[2], col);
                } else if (comp instanceof JSeparator) {
                    applyForegroundColor(comp, value[2], col);
                }
            }
            if (comp instanceof Container) {
                printAllComponents((Container) comp, col);
            }
        }
    }

    private static void applyBackgroundColor(Component c, String value, Color newPrimaryColor) {
        switch (value) {
            /*case "0"://///////////////APLICADO CUANDO SE OBTENGA COLOR SECUNDARIO
                c.setBackground(UI.getPrimaryColor());
                break;*/
            case "1":
                c.setBackground(newPrimaryColor);
                break;
        }
    }

    private static void applyButtonBorderColor(JButton btn, String borderColor, Color newPrimaryColor) {
        switch (borderColor) {
            /*case "0":
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(UI.getSecundaryColor()));
                break;*/
            case "1":
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(newPrimaryColor));
                break;
        }
    }

    private static void applyForegroundColor(Component c, String foregroundColor, Color newPrimaryColor) {
        switch (foregroundColor) {
            /*case "0":
                c.setForeground(UI.getSecundaryColor());
                break;*/
            case "1":
                c.setForeground(newPrimaryColor);
                break;
        }
    }

    private static void applyBackgroundTableHeaderColor(JTable t, String value, Color newPrimaryColor) {
        switch (value) {
            /*case "0"://///////////////APLICADO CUANDO SE OBTENGA COLOR SECUNDARIO
                c.setBackground(UI.getPrimaryColor());
                break;*/
            case "1":
                t.getTableHeader().setBackground(newPrimaryColor);
                break;
        }
    }

    private static void applyBorderTableHeaderColor(JTable t, String borderColor, Color newPrimaryColor) {
        switch (borderColor) {
            /*case "0":
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(UI.getSecundaryColor()));
                break;*/
            case "1":
                t.getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(newPrimaryColor));
                break;
        }
    }

    private static void applyBackgroundPanelColor(JPanel pnl, String value, Color newPrimaryColor) {
        switch (value) {
            /*case "0"://///////////////APLICADO CUANDO SE OBTENGA COLOR SECUNDARIO
                c.setBackground(UI.getPrimaryColor());
                break;*/
            case "1":
                pnl.setBackground(newPrimaryColor);
                break;
        }
    }

    private static void applyBorderPanelColor(JPanel pnl, String borderColor, Color newPrimaryColor) {
        switch (borderColor) {
            /*case "0":
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(UI.getSecundaryColor()));
                break;*/
            case "1":
                pnl.setBorder(javax.swing.BorderFactory.createLineBorder(newPrimaryColor));
                break;
        }
    }

    private static void getNewIcon(Icon oldIcon) {
        /*splitear por / obtener las finales hasta la raiz(con las cuales
        se setara el nuevo icono, de la ultima splitear por - y la última contendra el color,
        además del .extension)*/
        
                System.out.println(oldIcon.toString());

        String oldPath[] = oldIcon.toString().split("\\-");
        oldPath[oldPath.length - 1] =/*nuevo Color;*/ "PRUEBA";
        StringBuilder newPath = new StringBuilder();
        for (int i = 0; i < oldPath.length; i++) {
            if (i != oldPath.length) {
                newPath.append(oldPath[i] + "-");
            }
        }
        StringBuilder x = new StringBuilder();
        for (String string : oldPath) {
            x.append(string);
        }

        System.out.println(x.toString());
        System.out.println(newPath.toString());
    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Metodo que agrupa el evento entered de algunos botones de la interfaz.
     *
     * @param evt Evento, en este caso Entered.
     */
    public static void mouseComponentEffect(java.awt.event.MouseEvent evt) {
        Component callingComponent = evt.getComponent();
        String[] values = callingComponent.getAccessibleContext().getAccessibleName().split("\\$");

        if (evt.getComponent() instanceof JButton) {
            applyBackgroundColorEffect(callingComponent, values[0]);
            applyButtonBorderColorEffect((JButton) callingComponent, values[1]);
            applyForegroundColorEffect(callingComponent, values[2]);
            callingComponent.getAccessibleContext().setAccessibleName(changeValues(values));

        } else if (evt.getComponent() instanceof JPanel) {
            jPanelEffects((JPanel) callingComponent, values);
        }
    }

    public static void jPanelEffects(JPanel pnl, String[] values) {
        if (pnl instanceof Container) {
            ArrayList<Component> innerPanelComponents = getAllComponents(pnl);
            for (Component innerPanelComponent : innerPanelComponents) {
                if (innerPanelComponent instanceof JLabel && innerPanelComponent.getAccessibleContext().getAccessibleName().contains("$")) {////aqui
                    String[] innerPanelComponentValues = innerPanelComponent.getAccessibleContext().getAccessibleName().split("\\$");
                    applyForegroundColorEffect(innerPanelComponent, innerPanelComponentValues[2]);
                    innerPanelComponent.getAccessibleContext().setAccessibleName(changeValues(innerPanelComponentValues));
                }
            }
        }
        applyBackgroundColorEffect(pnl, values[0]);
        applyPanelBorderColorEffect(pnl, values[1]);
        applyForegroundColorEffect(pnl, values[2]);
        pnl.getAccessibleContext().setAccessibleName(changeValues(values));
    }

    private static void applyBackgroundColorEffect(Component c, String backgroundColor) {
        switch (backgroundColor) {
            case "0":
                c.setBackground(UI.getPrimaryColor());
                break;
            case "1":
                c.setBackground(UI.getSecundaryColor());
                break;
        }
    }

    private static void applyButtonBorderColorEffect(JButton btn, String borderColor) {
        switch (borderColor) {
            case "1":
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(UI.getSecundaryColor()));
                break;
            case "0":
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(UI.getPrimaryColor()));
                break;
        }
    }

    private static void applyPanelBorderColorEffect(JPanel pnl, String borderColor) {
        switch (borderColor) {
            case "1":
                pnl.setBorder(javax.swing.BorderFactory.createLineBorder(UI.getSecundaryColor()));
                break;
            case "0":
                pnl.setBorder(javax.swing.BorderFactory.createLineBorder(UI.getPrimaryColor()));
                break;
        }
    }

    private static void applyForegroundColorEffect(Component c, String foregroundColor) {
        switch (foregroundColor) {
            case "1":
                c.setForeground(UI.getSecundaryColor());
                break;
            case "0":
                c.setForeground(UI.getPrimaryColor());
                break;
        }
    }

    private static String changeValues(String[] values) {
        StringBuilder accesibleName = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (values[i].equals("0")) {
                accesibleName.append("1");
            } else if (values[i].equals("1")) {
                accesibleName.append("0");
            } else if (values[i].equals("-")) {
                accesibleName.append("-");
            }

            if (i != values.length) {
                accesibleName.append("$");
            }
        }
        return accesibleName.toString();
    }

}
