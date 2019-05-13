/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;

/**
 *
 * @author Antonio Jose Adamuz Sereno
 */
public class Images {

    private Blob imageEncoded;
    private ImageIcon image;
    private int codeImage;
    private String description;
    private int codeSuspect;

    /*Constructor para cuando obtengas info de la bd*/
    public Images(Blob Image, int CodeImage, String Description,
            int CodeSuspect) {
        //?super();
        this.imageEncoded = Image;
        this.codeImage = CodeImage;
        this.description = Description;
        this.codeSuspect = CodeSuspect;
    }

    public Images(Image image) {
        transformImage(image);
    }

    public void transformImage(Image image) {
        this.image = new ImageIcon(image);
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(Image Image) {
        transformImage(Image);
    }

    public int getCodeImage() {
        return codeImage;
    }

    public void setCodeImage(int CodeImage) {
        this.codeSuspect = CodeImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public int getCodeSuspect() {
        return codeSuspect;
    }

    public void setCodeSuspect(int CodeSuspect) {
        this.codeSuspect = CodeSuspect;
    }

    public void encondeImage(ImageIcon imageToEnconde) throws SQLException {
        BufferedImage image = new BufferedImage(imageToEnconde.getIconWidth(),
                imageToEnconde.getIconHeight(), BufferedImage.TYPE_INT_RGB);

        // Create a graphics object to draw the image 
        Graphics g = image.createGraphics();

        // Paint the icon on to the buffered image
        imageToEnconde.paintIcon(null, g, 0, 0);
        g.dispose();

        // Convert the buffered image into a byte array
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", b);
        } catch (Exception ex) {
            // Handle the exception
        }
        byte[] imageInByte = b.toByteArray();

        // Return the Base64 encoded String
        imageEncoded = new SerialBlob(Base64.getEncoder().encode(imageInByte));
    }

    private void decodeImage() {
        try {
            byte[] data = imageEncoded.getBytes(1, (int) imageEncoded.length());
            BufferedImage img = null;

            try {
                img = ImageIO.read(new ByteArrayInputStream(data));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            ImageIcon icono = new ImageIcon(img);
        } catch (Exception e) {

        }
    }
}
