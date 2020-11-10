/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author pabloantoniolopezmartin
 */
public class Lienzo extends JPanel {
    private static BufferedImage imagen=null;
    
 
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen,0,0,null);
        
    }
    public static void setImage(BufferedImage imagen){
        Lienzo.imagen=imagen;
    }
    public static BufferedImage getImage(){
        return imagen;
    }
   
}
