/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.cursos;
import factory.DaoFactory;
import gui.inisioSesion.PantallaDatos;
import interfazDao.IDao;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import models.Curso;

/**
 *
 * @author estudiante
 */
public class ModificarCurso extends javax.swing.JFrame {

    /**
     * Creates new form ModificarCurso
     */
    public ModificarCurso(Curso curso) {
        initComponents();
        this.setLocationRelativeTo(null);
        setLabelImage();
        jLabelCodigo.setText(String.valueOf(curso.getCodigo()));
        jTextFieldNombre.setText(curso.getNombre());
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jLabelBack = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jLabel1.setText("DATOS CURSO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 30, 100, 30);

        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jLabel2.setText("CODIGO: ");
        jPanel1.add(jLabel2);
        jPanel1.add(jLabelCodigo);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jLabel4.setText("NOMBRE: ");
        jPanel1.add(jLabel4);
        jPanel1.add(jTextFieldNombre);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(87, 126, 350, 80);

        jButtonUpdate.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jButtonUpdate.setText("ACTUALIZAR");
        jButtonUpdate.setBorder(null);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate);
        jButtonUpdate.setBounds(200, 310, 110, 30);

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

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        int codigo;
        String nombre;
        
        codigo = Integer.parseInt(jLabelCodigo.getText());
        nombre = jTextFieldNombre.getText();
        
        Curso curso = new Curso (codigo, nombre);
        
        try {
            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.CURSO);
            dao.updateRecord(curso, codigo);
            PantallaDatos pD = new PantallaDatos ("cursos");
            pD.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModificarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        PantallaDatos pD;
        try {
            pD = new PantallaDatos("cursos");
            pD.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModificarCurso.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
