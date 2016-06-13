//clase para poner imagen de fondo en frame

package modelo;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jaume
 */
public class ImagenFondo extends JPanel{
 private Image fondo=null;
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo,160,0,getWidth()-160,getHeight(),null);
        setOpaque(false);
    }
    public void setImage(String image){
        if (image!=null) {
            fondo=new ImageIcon(getClass().getResource(image)).getImage();
        }
    }
}