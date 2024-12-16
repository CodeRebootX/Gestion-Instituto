/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDao;

import interfazDao.IDao;
import models.Profesor;

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
public class ProfesorDao implements IDao<Profesor, Integer>{
    private Connection conex;
    private PreparedStatement preQuery;
    private boolean isSuccesfully = false;
    private Profesor profe;
    private List<Profesor> profesores;
    private String insertar = "INSERT INTO profesores (id_prof, dni_prof, nom_prof, ape_prof, naci_prof, cpostal_prof, tfn_prof) VALUES (?,?,?,?,?,?,?)";
    private String leer = "SELECT * FROM profesores WHERE id_prof=?";
    private String actualizar = "UPDATE profesores SET id_prof=?, dni_prof=?, nom_prof=?, ape_prof=?, naci_prof=?, cpostal_prof=?, tfn_prof=? WHERE (id_prof=?)";
    private String borrar = "DELETE FROM profesores WHERE (id_prof=?)";
    private String verTabla = "SELECT * FROM profesores";
    
    
public ProfesorDao() throws ClassNotFoundException {
    conex= Connect2Db.getInstance().getConnection();
    profe = new Profesor();
    profesores = new ArrayList();
}

    @Override
    public boolean createRecord(Profesor model) {
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
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSuccesfully;
    }

    @Override
    public Profesor readRecord(Integer idModel) {
       try {
           preQuery=conex.prepareStatement(leer);
           preQuery.setInt(1, idModel);
           ResultSet data = preQuery.executeQuery();
           
           if (data.next()) {
               profe.setId(data.getInt("id_prof"));
               profe.setDni(data.getString("dni_prof"));
               profe.setNombre(data.getString("nom_prof"));
               profe.setApellido(data.getString("ape_prof"));
               profe.setNacimiento(data.getString("naci_prof"));
               profe.setCod_postal(data.getInt("cpostal_prof"));
               profe.setTelefono(data.getInt("tfn_prof"));  
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return profe;
    }

    @Override
    public boolean updateRecord(Profesor model, Integer idModel) {
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
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public List<Profesor> readRecords() {
        try {
            preQuery = conex.prepareStatement(verTabla);
            ResultSet data = preQuery.executeQuery();
            
            while (data.next()) {
                profesores.add(new Profesor(data.getInt("id_prof"), data.getString("dni_prof"), data.getString("nom_prof"), data.getString("ape_prof"), data.getString("naci_prof"), data.getInt("cpostal_prof"), data.getInt("tfn_prof")));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesores;
    }


    
}
