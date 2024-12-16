/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDao;

import interfazDao.IDao;
import models.Alumno;

import dbConections.Connect2Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class AlumnoDao implements IDao<Alumno, Integer>{
    private Connection conex;
    private PreparedStatement preQuery;
    private boolean isSuccesfully = false;
    private Alumno alum;
    private List<Alumno> alumnos;
    private String insertar = "INSERT INTO alumnos (id_alum, dni_alum, nom_alum, ape_alum, naci_alum, cpostal_alum, tfn_alum) VALUES (?,?,?,?,?,?,?)";
    private String leer = "SELECT * FROM alumnos WHERE id_alum=?";
    private String actualizar = "UPDATE alumnos SET id_alum=?, dni_alum=?, nom_alum=?, ape_alum=?, naci_alum=?, cpostal_alum=?, tfn_alum=? WHERE (id_alum=?)";
    private String borrar = "DELETE FROM alumnos WHERE (id_alum=?)";
    private String verTabla = "SELECT * FROM alumnos";
    
    
public AlumnoDao() throws ClassNotFoundException {
    conex= Connect2Db.getInstance().getConnection();
    alum = new Alumno();
    alumnos = new ArrayList();
}

    @Override
    public boolean createRecord(Alumno model) {
        try {
            preQuery = conex.prepareStatement(insertar);
            preQuery.setInt(1, model.getId());
            preQuery.setString(2, model.getDni());
            preQuery.setString(3, model.getNombre());
            preQuery.setString(4, model.getApellido());
            preQuery.setString(5,model.getNacimiento());
            preQuery.setInt(6, model.getCod_postal());
            preQuery.setInt(7, model.getTelefono());
            
                       
            if (preQuery.executeUpdate() >0) {
            isSuccesfully = true;
        }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSuccesfully;
    }

    @Override
    public Alumno readRecord(Integer idModel) {
       try {
           preQuery=conex.prepareStatement(leer);
           preQuery.setInt(1, idModel);
           ResultSet data = preQuery.executeQuery();
           
           if (data.next()) {
               alum.setId(data.getInt("id_alum"));
               alum.setDni(data.getString("dni_alum"));
               alum.setNombre(data.getString("nom_alum"));
               alum.setApellido(data.getString("ape_alum"));
               alum.setNacimiento(data.getString("naci_alum"));
               alum.setCod_postal(data.getInt("cpostal_alum"));
               alum.setTelefono(data.getInt("tfn_alum"));  
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return alum;
    }

    @Override
    public boolean updateRecord(Alumno model, Integer idModel) {
        try {
            preQuery = conex.prepareStatement(actualizar);
            preQuery.setInt(1, model.getId());
            preQuery.setString(2, model.getDni());
            preQuery.setString(3, model.getNombre());
            preQuery.setString(4, model.getApellido());
            preQuery.setString(5, model.getNacimiento());
            preQuery.setInt(6, model.getCod_postal());
            preQuery.setInt(7, model.getTelefono());
            preQuery.setInt(8, idModel);
            
            if (preQuery.executeUpdate()>0) {
                isSuccesfully = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public boolean deleteRecord(Integer idModel) {
        try {
            preQuery=conex.prepareStatement(borrar);
            preQuery.setInt(1, idModel);
            if (preQuery.executeUpdate() > 0) {
                isSuccesfully= true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public List<Alumno> readRecords() {
        try {
            preQuery = conex.prepareStatement(verTabla);
            ResultSet data = preQuery.executeQuery();
            
            while (data.next()) {
                alumnos.add(new Alumno(data.getInt("id_alum"), data.getString("dni_alum"), data.getString("nom_alum"), data.getString("ape_alum"), data.getString("naci_alum"), data.getInt("cpostal_alum"), data.getInt("tfn_alum")));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }   
}
