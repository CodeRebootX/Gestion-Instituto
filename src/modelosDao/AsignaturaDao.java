/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDao;

import interfazDao.IDao;
import models.Asignatura;

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
public class AsignaturaDao implements IDao<Asignatura, Integer>{
    private Connection conex;
    private PreparedStatement preQuery;
    private boolean isSuccesfully = false;
    private Asignatura asig;
    private List<Asignatura> asignaturas;
    private String insertar = "INSERT INTO asignaturas (cod_asig, nomb_asig, horas) VALUES (?,?,?)";
    private String leer = "SELECT * FROM asignaturas WHERE cod_asig=?";
    private String actualizar = "UPDATE asignaturas SET cod_asig=?, nomb_asig=?, horas=? WHERE (cod_asig=?)";
    private String borrar = "DELETE FROM asignaturas WHERE (cod_asig=?)";
    private String verTabla = "SELECT * FROM asignaturas";
    
    
public AsignaturaDao() throws ClassNotFoundException {
    conex= Connect2Db.getInstance().getConnection();
    asig = new Asignatura();
    asignaturas = new ArrayList();
}

    @Override
    public boolean createRecord(Asignatura model) {
        try {
            preQuery = conex.prepareStatement(insertar);
            preQuery.setInt(1, model.getCodigo());
            preQuery.setString(2, model.getNombre());
            preQuery.setInt(3, model.getHoras());
            
                       
            if (preQuery.executeUpdate() >0) {
            isSuccesfully = true;
        }
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSuccesfully;
    }

    @Override
    public Asignatura readRecord(Integer idModel) {
       try {
           preQuery=conex.prepareStatement(leer);
           preQuery.setInt(1, idModel);
           ResultSet data = preQuery.executeQuery();
           
           if (data.next()) {
               asig.setCodigo(data.getInt("cod_asig"));
               asig.setNombre(data.getString("nomb_asig"));
               asig.setHoras(data.getInt("horas"));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return asig;
    }

    @Override
    public boolean updateRecord(Asignatura model, Integer idModel) {
        try {
            preQuery = conex.prepareStatement(actualizar);
            preQuery.setInt(1, model.getCodigo());
            preQuery.setString(2, model.getNombre());
            preQuery.setInt(3, model.getHoras());
            preQuery.setInt(4, idModel);
            
            if (preQuery.executeUpdate()>0) {
                isSuccesfully = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public List<Asignatura> readRecords() {
        try {
            preQuery = conex.prepareStatement(verTabla);
            ResultSet data = preQuery.executeQuery();
            
            while (data.next()) {
                asignaturas.add(new Asignatura(data.getInt("cod_asig"), data.getString("nomb_asig"), data.getInt("horas")));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asignaturas;
    }    
}
