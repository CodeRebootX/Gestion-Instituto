/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.inisioSesion;

import factory.DaoFactory;
import gui.alumnos.InsertarAlumno;
import gui.alumnos.ModificarAlumnos;
import gui.asignaturas.InsertarAsignatura;
import gui.asignaturas.ModificarAsignatura;
import gui.aulas.InsertarAula;
import gui.aulas.ModificarAula;
import gui.cursos.InsertarCurso;
import gui.cursos.ModificarCurso;
import gui.profesores.InsertarProfesor;
import gui.profesores.ModificarProfesores;
import interfazDao.IDao;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import models.Alumno;
import models.Asignatura;
import models.Aula;
import models.Curso;
import models.Entidad;
import models.Profesor;

/**
 *
 * @author estudiante
 */
public class PantallaDatos extends javax.swing.JFrame {
    private boolean boolProfesor = false;
    private boolean boolAlumno= false;
    private boolean boolAsignatura = false;
    private boolean boolAula = false;
    private boolean boolCurso = false;

    /**
     * Creates new form PantallaDatos
     */
    public PantallaDatos(String tabla) throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        setLabelImage();
        initTabla(tabla);
        
        
        //int rows;
        if (tabla.equals("profesores")) {
            Profesor profesor = new Profesor();    
            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.PROFESOR);    
            List<Profesor> profesores = new ArrayList();      
            //int idProfesor;      
            profesores=dao.readRecords();
            for (Profesor profe: profesores) {
                refrescarTabla(profe);
            }
            boolProfesor=true;
        }
        
        if (tabla.equals("alumnos")) {
            
            Alumno alumno = new Alumno();    
            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.ALUMNO);    
            List<Alumno> alumnos = new ArrayList();      
            //int idProfesor;      
            alumnos=dao.readRecords();
            for (Alumno alum: alumnos) {
                refrescarTabla(alum);
            }
            boolAlumno=true;
        }
        
        if (tabla.equals("asignaturas")) {
            
            Asignatura asig = new Asignatura();   
            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.ASIGNATURA);    
            List<Asignatura> asignaturas = new ArrayList();      
            //int idProfesor;      
            asignaturas=dao.readRecords();
            for (Asignatura asignatura : asignaturas) {
                refrescarTabla(asignatura);
            }
            boolAsignatura=true;
        }
        
        if (tabla.equals("aulas")) {
            
            Aula aula = new Aula();   
            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.AULA);    
            List<Aula> aulas = new ArrayList();      
            //int idProfesor;      
            aulas=dao.readRecords();
            for (Aula aul: aulas) {
                refrescarTabla(aul);
            }
            boolAula=true;
        }
        
        if (tabla.equals("cursos")) {
            
            Curso curso = new Curso();    
            IDao dao = DaoFactory.getDao(DaoFactory.DaoType.CURSO);    
            List<Curso> cursos = new ArrayList();      
            //int idProfesor;      
            cursos=dao.readRecords();
            for (Curso cur : cursos) {
                refrescarTabla(cur);
            }
            boolCurso=true;
        }
        
        
    }
    
    private void initTabla(String nombre) {
        DefaultTableModel model = new DefaultTableModel () {
            @Override
            public boolean isCellEditable (int row, int column) {
                return false;
            }
        };
        if (nombre.equals("profesores")) {
            jLabelNombreTabla.setText("Lista "+nombre);
            model.setColumnIdentifiers(new String []{"id", "Dni", "Nombre", "Apellido", "Nacimiento", "Codigo postal", "Telefono"});
            jTable1.setModel(model);
            JTableHeader header = jTable1.getTableHeader();              
            header.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        }
        
        if (nombre.equals("alumnos")) {
            jLabelNombreTabla.setText("Lista "+nombre);
            model.setColumnIdentifiers(new String []{"id", "Dni", "Nombre", "Apellido", "Nacimiento", "Codigo postal", "Telefono"});
            jTable1.setModel(model);
            JTableHeader header = jTable1.getTableHeader();              
            header.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        }
        
        if (nombre.equals("asignaturas")) {
            jLabelNombreTabla.setText("Lista "+nombre);
            model.setColumnIdentifiers(new String []{"Código asignatura", "Nombre", "Horas"});
            jTable1.setModel(model);
            JTableHeader header = jTable1.getTableHeader();              
            header.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        }
        
        if (nombre.equals("aulas")) {
            jLabelNombreTabla.setText("Lista "+nombre);
            model.setColumnIdentifiers(new String []{"Código aula", "Nombre", "Num. pupitres"});
            jTable1.setModel(model);
            JTableHeader header = jTable1.getTableHeader();              
            header.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        }
        
        if (nombre.equals("cursos")) {
            jLabelNombreTabla.setText("Lista "+nombre);
            model.setColumnIdentifiers(new String []{"Código curso", "Nombre"});
            jTable1.setModel(model);
            JTableHeader header = jTable1.getTableHeader();              
            header.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        }
        
        
        
    }
    
    
    
    private void refrescarTabla (Entidad entidad) {
       
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(entidad.toArrayString());
        
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombreTabla = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jButtonCreate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabelBack = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jLabelNombreTabla.setFont(new java.awt.Font("Bahnschrift", 3, 24)); // NOI18N
        jLabelNombreTabla.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNombreTabla.setText("Lista Profesores");
        getContentPane().add(jLabelNombreTabla);
        jLabelNombreTabla.setBounds(320, 20, 210, 30);
        getContentPane().add(jLabelLogo);
        jLabelLogo.setBounds(120, 10, 120, 50);

        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelExit);
        jLabelExit.setBounds(750, 10, 30, 30);

        jButtonCreate.setBackground(new java.awt.Color(2, 132, 54));
        jButtonCreate.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jButtonCreate.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCreate.setText("Create");
        jButtonCreate.setBorder(null);
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCreate);
        jButtonCreate.setBounds(210, 110, 110, 30);

        jTable1.setBackground(new java.awt.Color(213, 231, 248));
        jTable1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 156, 794, 438);

        jButtonUpdate.setBackground(new java.awt.Color(2, 132, 54));
        jButtonUpdate.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(0, 0, 0));
        jButtonUpdate.setText("Update");
        jButtonUpdate.setBorder(null);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate);
        jButtonUpdate.setBounds(350, 110, 110, 30);

        jButtonDelete.setBackground(new java.awt.Color(2, 132, 54));
        jButtonDelete.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDelete.setText("Delete");
        jButtonDelete.setBorder(null);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDelete);
        jButtonDelete.setBounds(490, 110, 110, 30);

        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBack);
        jLabelBack.setBounds(10, 10, 30, 30);
        getContentPane().add(jLabelFondo);
        jLabelFondo.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        // TODO add your handling code here:
        if (boolProfesor) {
            InsertarProfesor insertar = new InsertarProfesor(this,true);
            insertar.setVisible(true);
            dispose();
        }
        
        if (boolAlumno) {
            InsertarAlumno insertar = new InsertarAlumno(this, true);
            insertar.setVisible(true);
            dispose();
        }
        
        if (boolAsignatura) {
            InsertarAsignatura insertar = new InsertarAsignatura(this, true);
            insertar.setVisible(true);
            dispose();
        }
        
        if (boolAula) {
            InsertarAula insertar = new InsertarAula(this, true);
            insertar.setVisible(true);
            dispose();
        }
        
        if (boolCurso) {
            InsertarCurso insertar = new InsertarCurso(this, true);
            insertar.setVisible(true);
            dispose();
        }
        
        
        
        
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow()!= -1) {
            int removeIndex;
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();           
            removeIndex = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
            int id =Integer.parseInt(String.valueOf(model.getValueAt(removeIndex, 0)));
            
            if (boolProfesor) {
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.PROFESOR);
                    dao.deleteRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                model.removeRow(removeIndex);
            }
            
            if (boolAlumno) {
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.ALUMNO);
                    dao.deleteRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }

                model.removeRow(removeIndex);
            }
            
            if (boolAsignatura) {
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.ASIGNATURA);
                    dao.deleteRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }

                model.removeRow(removeIndex);
            }
            
            if (boolAula) {
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.AULA);
                    dao.deleteRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }

                model.removeRow(removeIndex);
            }
            
            if (boolCurso) {
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.CURSO);
                    dao.deleteRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }

                model.removeRow(removeIndex);
            }
            
            
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int updateIndex;
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            updateIndex = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
            int id =Integer.parseInt(String.valueOf(model.getValueAt(updateIndex, 0)));
            
            if (boolProfesor) {
                Profesor profe = new Profesor();
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.PROFESOR);
                    profe=(Profesor)dao.readRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                ModificarProfesores mP = new ModificarProfesores (profe);
                mP.setVisible(true);
                dispose();
            }
            
            if (boolAlumno) {
                Alumno alumno = new Alumno();
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.ALUMNO);
                    alumno=(Alumno)dao.readRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                ModificarAlumnos mA = new ModificarAlumnos (alumno);
                mA.setVisible(true);
                dispose();
            }
            
            if (boolAsignatura) {
                Asignatura asig = new Asignatura();
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.ASIGNATURA);
                    asig=(Asignatura)dao.readRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                ModificarAsignatura mA = new ModificarAsignatura (asig);
                mA.setVisible(true);
                dispose();
            }
            
            if (boolAula) {
                Aula aula = new Aula();
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.AULA);
                    aula=(Aula)dao.readRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                ModificarAula mA = new ModificarAula (aula);
                mA.setVisible(true);
                dispose();
            }
            
            if (boolCurso) {
                Curso curso = new Curso();
                try { 
                    IDao dao = DaoFactory.getDao(DaoFactory.DaoType.CURSO);
                    curso=(Curso)dao.readRecord(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                ModificarCurso mC = new ModificarCurso (curso);
                mC.setVisible(true);
                dispose();
            }
        }  
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        PantallaEntidades pp = new PantallaEntidades();
        pp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelBackMouseClicked

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void setLabelImage() {
        String currentDir = System.getProperty("user.dir");
        String imagePath = currentDir + "/src/img/HomeItaca.jpg";
        String imagePath2 = currentDir + "/src/img/LogoItaca.png";
        String imagePath3 = currentDir + "/src/img/cerrar-sesion.png";
        String imagePath4 = currentDir + "/src/img/flecha-izquierda.png";
        
        //jTable1.setBackground(new Color(213,231,248, 0));
           
        Image imag1 = Toolkit.getDefaultToolkit().createImage(imagePath);
        imag1 = imag1.getScaledInstance(jLabelFondo.getWidth(), jLabelFondo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(imag1);
        jLabelFondo.setIcon(img2);
        
        Image imag2 = Toolkit.getDefaultToolkit().createImage(imagePath2);
        imag2 = imag2.getScaledInstance(jLabelLogo.getWidth(), jLabelLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(imag2);
        jLabelLogo.setIcon(img3);
        
        Image imag3 = Toolkit.getDefaultToolkit().createImage(imagePath3);
        imag3 = imag3.getScaledInstance(jLabelExit.getWidth(), jLabelExit.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img4 = new ImageIcon(imag3);
        jLabelExit.setIcon(img4);
        
        Image imag4 = Toolkit.getDefaultToolkit().createImage(imagePath4);
        imag4 = imag4.getScaledInstance(jLabelBack.getWidth(), jLabelBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img5 = new ImageIcon(imag4);
        jLabelBack.setIcon(img5);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombreTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
