package BloqueoCC;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public final class Bloqueo extends javax.swing.JFrame 
{
    String arreglo[];
    String numeroMaquina;
    ruta aux = new ruta();
    public Bloqueo() 
    {
        iniciarTodo();
        initComponents();
        numeroMaquina = JavaPrueba.conect.nueva.leerNumeroMaquina();
        new Thread(nuevo).start();
        acomodarPanel();
    }
    
    public void iniciarTodo()
    {
        JavaPrueba.initCliente(aux.getIP());
        JavaPrueba.conect.enviarM("Conectado");
        fondo f = new fondo();
        setContentPane(f);
    }
    
    public void acomodarPanel()
    {
        this.setLayout(null);
        elPanel.setBounds(435,110,510,548);
        elPanel.setBackground(new Color(0,0,0,210));
        ImageIcon image = new ImageIcon(JavaPrueba.conect.nueva.getRuta()+"imagen3.png");
        image = new ImageIcon(image.getImage().getScaledInstance(183, 150, Image.SCALE_DEFAULT));
        numeroMaquinaLocal.setText(numeroMaquina);
        imagen.setIcon(image);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elPanel = new javax.swing.JPanel();
        numeroMaquinaLocal = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        texto2 = new javax.swing.JLabel();
        labeeel = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1367, 761));
        setUndecorated(true);
        setResizable(false);
        setSize(1300,900);

        elPanel.setBackground(new java.awt.Color(102, 102, 102));
        elPanel.setForeground(new java.awt.Color(255, 255, 255));

        numeroMaquinaLocal.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        numeroMaquinaLocal.setForeground(new java.awt.Color(255, 255, 255));
        numeroMaquinaLocal.setText("10");

        button.setBackground(new java.awt.Color(60, 179, 113));
        button.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setText("Aceptar");
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        texto2.setFont(new java.awt.Font("Tw Cen MT", 1, 25)); // NOI18N
        texto2.setForeground(new java.awt.Color(255, 255, 255));
        texto2.setText("Favor de registrarse");

        labeeel.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        labeeel.setForeground(new java.awt.Color(255, 255, 255));
        labeeel.setText("Numero De Equipo ");

        label1.setFont(new java.awt.Font("Tw Cen MT", 1, 25)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Equipo Bloqueado");

        javax.swing.GroupLayout elPanelLayout = new javax.swing.GroupLayout(elPanel);
        elPanel.setLayout(elPanelLayout);
        elPanelLayout.setHorizontalGroup(
            elPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(elPanelLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, elPanelLayout.createSequentialGroup()
                .addGap(115, 117, Short.MAX_VALUE)
                .addGroup(elPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, elPanelLayout.createSequentialGroup()
                        .addComponent(labeeel)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, elPanelLayout.createSequentialGroup()
                        .addComponent(numeroMaquinaLocal)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, elPanelLayout.createSequentialGroup()
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, elPanelLayout.createSequentialGroup()
                        .addComponent(texto2)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, elPanelLayout.createSequentialGroup()
                        .addComponent(label1)
                        .addGap(153, 153, 153))))
        );
        elPanelLayout.setVerticalGroup(
            elPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(elPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labeeel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(numeroMaquinaLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BloqueoCC/sinfondo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(elPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 391, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1045, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(elPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(477, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
            setVisible(false);
    }//GEN-LAST:event_buttonActionPerformed
    
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
                    label1.setText("El Equipo se ah desbloqueado");
                    button.setVisible(true);
                    this.setExtendedState(0);
                    texto2.setVisible(false);
                }
                else
                {
                    label1.setText("Equipo Bloqueado");
                    texto2.setVisible(true);
                    button.setVisible(false);
                    //this.setExtendedState(MAXIMIZED_BOTH);
                    setVisible(true);
                }
                Thread.sleep(5000);
            }
            catch (InterruptedException ex) 
            {
                JOptionPane.showMessageDialog(null,"we have a problems");
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
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.JPanel elPanel;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labeeel;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel numeroMaquinaLocal;
    private javax.swing.JLabel texto2;
    // End of variables declaration//GEN-END:variables
}
