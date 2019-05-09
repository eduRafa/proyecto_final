/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author rafa0
 */
public class Communication {

    static Document getDocumentXML() {
        Document docParsed = null;

        try {
            DocumentBuilder doc = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            docParsed = doc.parse(new File("./colors.xml"));//debería de ser dinámico
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docParsed;
    }

    public static void setPrimaryColor(Color c) {
        if (c != null) {
            boolean changed = false;
            Document doc = getDocumentXML();
            NodeList object = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < object.getLength(); i++) {
                Node tempNode = object.item(i);
                if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (tempNode.getNodeName().equals("primaryColor")) {
                        tempNode.setTextContent(String.valueOf(c.getRed()) + ","
                                + String.valueOf(c.getGreen()) + "," + (String.valueOf(
                                c.getBlue())));
                        saveDocument(doc);
                    }
                }
            }
        }
    }

    static void saveDocument(Document doc) {
        File color = new File("colors.xml");/*Deberia de ser dinámico(Pasar por
        parametro la ruta o en este caso el nombre del archivo ya que se 
        encunentra en la raiz)*/

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(color);//color: Debería de ser dinámico
            Source input = new DOMSource(doc);
            try {
                transformer.transform(input, output);

            } catch (TransformerException ex) {
                Logger.getLogger(Communication.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Communication.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String xmlToString(Document xml) {
        String xmlString = null;

        if (xml != null) {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer;

            try {
                transformer = tf.newTransformer();

                // Uncomment if you do not require XML declaration
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                //A character stream that collects its output in a string buffer,
                //which can then be used to construct a string.
                StringWriter writer = new StringWriter();

                //transform document to string
                transformer.transform(new DOMSource(xml), new StreamResult(writer));

                xmlString = writer.getBuffer().toString();
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return xmlString;
    }

    public static Color getPrimaryColor() {
        Color pnlColor = null;
        Document doc = getDocumentXML();
        NodeList object = doc.getDocumentElement().getChildNodes();

        for (int i = 0; i < object.getLength(); i++) {
            Node tempNode = object.item(i);
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                if (tempNode.getNodeName().equals("primaryColor")) {
                    int[] rgb = new int[3];
                    String[] rgbString = tempNode.getTextContent().split(",");
                    for (int z = 0; z < rgbString.length; z++) {
                        rgb[z] = Integer.valueOf(rgbString[z]);
                    }
                    pnlColor = new Color(rgb[0], rgb[1], rgb[2]);
                }
            }
        }
        return pnlColor;
    }
}
