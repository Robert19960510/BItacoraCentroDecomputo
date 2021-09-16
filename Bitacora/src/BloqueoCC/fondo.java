
package BloqueoCC;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class fondo extends javax.swing.JPanel
{
    public fondo()
    {
       this.setSize(400,280);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon("C:\\Users\\a123\\AppData\\Local\\Bitacora\\src\\BloqueoCC\\Imagen.jpg");
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
