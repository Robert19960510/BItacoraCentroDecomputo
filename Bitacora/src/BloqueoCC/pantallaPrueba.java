package BloqueoCC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class pantallaPrueba extends JFrame
{
    fondo d = new fondo();
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel(new GridLayout(5,1,2,2));
    JPanel panel3 = new JPanel(null);
    JLabel imagen = new JLabel();
    JLabel logo = new JLabel();
    ruta nueva = new ruta();
    int width = getDefaultToolkit().getScreenSize().width;
    int height = getDefaultToolkit().getScreenSize().height;
    JLabel numMaquina = new JLabel();
    JLabel titulo = new JLabel("Numero de equipo");
    JLabel subtitulo = new JLabel("Equipo bloqueado");
    JLabel subtitulo2 = new JLabel("Por favor registrate");
    JButton boton = new JButton("Aceptar");
    String arreglo[];
    String numeroMaquina;
    
    public pantallaPrueba()
    {
        setSize(width,height);
        setContentPane(d);
        setUndecorated(true);
        setLayout(null);
        initComponents();
        initButton();
        panel.add(imagen,BorderLayout.NORTH);
        panel2.add(titulo);
        panel2.add(numMaquina);
        panel2.add(subtitulo);
        panel2.add(subtitulo2);
        panel3.add(boton);
        panel2.add(panel3);
        panel.add(panel2,BorderLayout.CENTER);
        add(logo);
        add(panel);
        JavaPrueba.initCliente(nueva.getIP());
        JavaPrueba.conect.enviarM("Conectado");
        new Thread(nuevo).start();
    }
    public void initComponents()
    {
        numeroMaquina = nueva.leerNumeroMaquina();
        numMaquina.setText(numeroMaquina);
        ImageIcon image = new ImageIcon(nueva.getRuta()+"imagen3.png");
        image = new ImageIcon(image.getImage().getScaledInstance(183, 150, Image.SCALE_DEFAULT));
        imagen.setIcon(image);
        ImageIcon imageLogo = new ImageIcon("C:\\Users\\a123\\AppData\\Local\\Bitacora\\src\\BloqueoCC\\sinfondo.png");
        imageLogo = new ImageIcon(imageLogo.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        logo.setIcon(imageLogo);
        logo.setBounds(5, 5, 250, 250);
        panel.setBounds(((width/2)-(510/2)),110,510,548);
        panel.setBackground(new Color(0,0,0,210));
        panel2.setBackground(new Color(0,0,0,100));
        panel3.setBackground(new Color(0,0,0,10));
        imagen.setHorizontalAlignment(JLabel.CENTER);
        setLabel(titulo,36);
        setLabel(numMaquina,36);
        setLabel(subtitulo,25);
        setLabel(subtitulo2,25);
    }
    
    public void initButton()
    {
        boton.setHorizontalAlignment(JLabel.CENTER);
        boton.setBackground(new Color(60,179,113));
        boton.setForeground(Color.white);
        boton.setBounds(((510/2)-(200/2)),10,200, 47);
        boton.setVisible(false);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                setVisible(false);
            }
        });
    }
    
    public void setLabel(JLabel label,int size)
    {
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial",Font.BOLD,size));
    }
    Runnable nuevo = () ->
    {
        hilo();
    };

    public void hilo()
    {
        while (true)
        {
            try 
            {
                verificarConexion();
                if (JavaPrueba.conect.estado)
                {
                    subtitulo.setText("El Equipo se ah desbloqueado");
                    boton.setVisible(true);
                    subtitulo2.setVisible(false);
                }
                else
                {
                    subtitulo.setText("Equipo Bloqueado");
                    subtitulo2.setVisible(true);
                    boton.setVisible(false);
                    setVisible(true);
                }
                Thread.sleep(5000);
            }
            catch (InterruptedException ex) 
            {
                ex.printStackTrace();
            }
        }
    }
    
    public void verificarConexion()
    {
        if (JavaPrueba.conect.verdad == false) 
        {
            JavaPrueba.conect.stop();
            System.out.println("se paro el server");
            JavaPrueba.conect.verdad = true;
            JavaPrueba.initCliente(JavaPrueba.conect.nueva.getIP());
            JavaPrueba.conect.enviarM("se conecto de nuevo");
        }
    }
}
