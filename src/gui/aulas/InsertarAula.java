/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

package gui.aulas;

import factory.DaoFactory;
import gui.inisioSesion.PantallaDatos;
import interfazDao.IDao;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import models.Aula;

/**
 *
 * @author estudiante
 */
public class InsertarAula extends javax.swing.JDialog {

    /** Creates new form InsertarAula */
    public InsertarAula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setLabelImage();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPiso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPupitres = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jLabelBack = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jLabelTitulo.setText("NUEVA AULA");
        getContentPane().add(jLabelTitulo);
        jLabelTitulo.setBounds(200, 20, 100, 30);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jLabel2.setText("CODIGO: ");
        jPanel1.add(jLabel2);
        jPanel1.add(jTextFieldCodigo);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jLabel3.setText("PISO: ");
        jPanel1.add(jLabel3);
        jPanel1.add(jTextFieldPiso);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jLabel4.setText("Nº PUPITRES: ");
        jPanel1.add(jLabel4);
        jPanel1.add(jTextFieldPupitres);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(49, 109, 390, 110);

        jButtonAgregar.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jButtonAgregar.setText("AGREGAR");
        jButtonAgregar.setBorder(null);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar);
        jButtonAgregar.setBounds(210, 310, 110, 30);

        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBack);
        jLabelBack.setBounds(10, 10, 30, 30);
        getContentPane().add(jLabelFondo);
        jLabelFondo.setBounds(0, 0, 500, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        int codigo;
        int piso;
        int pupitres;

        codigo = Integer.parseInt(jTextFieldCodigo.getText());
        piso = Integer.parseInt(jTextFieldPiso.getText());
        pupitres = Integer.parseInt(jTextFieldPupitres.getText());

        Aula aula = new Aula (codigo, piso, pupitres);

        try {
            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.AULA);
            dao.createRecord(aula);
            PantallaDatos pD = new PantallaDatos ("aulas");
            pD.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertarAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();

    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        PantallaDatos pD;
        try {
            pD = new PantallaDatos("aulas");
            pD.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertarAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jLabelBackMouseClicked

    private void setLabelImage() {
        String currentDir = System.getProperty("user.dir");
        String imagePath = currentDir + "/src/img/fondo-form.jpg";
        String imagePath4 = currentDir + "/src/img/flecha-izquierda.png";
        
        jPanel1.setBackground(new Color(221, 221, 221, 0));
           
        Image imag1 = Toolkit.getDefaultToolkit().createImage(imagePath);
        imag1 = imag1.getScaledInstance(jLabelFondo.getWidth(), jLabelFondo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(imag1);
        jLabelFondo.setIcon(img2);
        
        Image imag4 = Toolkit.getDefaultToolkit().createImage(imagePath4);
        imag4 = imag4.getScaledInstance(jLabelBack.getWidth(), jLabelBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img5 = new ImageIcon(imag4);
        jLabelBack.setIcon(img5);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldPiso;
    private javax.swing.JTextField jTextFieldPupitres;
    // End of variables declaration//GEN-END:variables

}
