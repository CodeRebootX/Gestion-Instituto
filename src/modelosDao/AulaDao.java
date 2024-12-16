/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDao;

import interfazDao.IDao;
import models.Aula;

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
public class AulaDao implements IDao<Aula, Integer>{
    private Connection conex;
    private PreparedStatement preQuery;
    private boolean isSuccesfully = false;
    private Aula aula;
    private List<Aula> aulas;
    private String insertar = "INSERT INTO aulas (cod_aula, piso, num_pupitres) VALUES (?,?,?)";
    private String leer = "SELECT * FROM aulas WHERE cod_aula=?";
    private String actualizar = "UPDATE aulas SET cod_aula=?, piso=?, num_pupitres=? WHERE (cod_aula=?)";
    private String borrar = "DELETE FROM aulas WHERE (cod_aula=?)";
    private String verTabla = "SELECT * FROM aulas";
    
    
public AulaDao() throws ClassNotFoundException {
    conex= Connect2Db.getInstance().getConnection();
    aula = new Aula();
    aulas = new ArrayList();
}

    @Override
    public boolean createRecord(Aula model) {
        try {
            preQuery = conex.prepareStatement(insertar);
            preQuery.setInt(1, model.getCodigo());
            preQuery.setInt(2, model.getPiso());
            preQuery.setInt(3, model.getNum_pupitres());
            
                       
            if (preQuery.executeUpdate() >0) {
            isSuccesfully = true;
        }
        } catch (SQLException ex) {
            Logger.getLogger(AulaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSuccesfully;
    }

    @Override
    public Aula readRecord(Integer idModel) {
       try {
           preQuery=conex.prepareStatement(leer);
           preQuery.setInt(1, idModel);
           ResultSet data = preQuery.executeQuery();
           
           if (data.next()) {
               aula.setCodigo(data.getInt("cod_aula"));
               aula.setPiso(data.getInt("piso"));
               aula.setNum_pupitres(data.getInt("num_pupitres"));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(AulaDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return aula;
    }

    @Override
    public boolean updateRecord(Aula model, Integer idModel) {
        try {
            preQuery = conex.prepareStatement(actualizar);
            preQuery.setInt(1, model.getCodigo());
            preQuery.setInt(2, model.getPiso());
            preQuery.setInt(3, model.getNum_pupitres());
            preQuery.setInt(4, idModel);
            
            if (preQuery.executeUpdate()>0) {
                isSuccesfully = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AulaDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AulaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public List<Aula> readRecords() {
        try {
            preQuery = conex.prepareStatement(verTabla);
            ResultSet data = preQuery.executeQuery();
            
            while (data.next()) {
                aulas.add(new Aula(data.getInt("cod_aula"), data.getInt("piso"), data.getInt("num_pupitres")));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(AulaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aulas;
    }    
}