/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDao;

import interfazDao.IDao;
import models.Curso;

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
public class CursoDao implements IDao<Curso, Integer>{
    private Connection conex;
    private PreparedStatement preQuery;
    private boolean isSuccesfully = false;
    private Curso curso;
    private List<Curso> cursos;
    private String insertar = "INSERT INTO cursos (cod_curso, nomb_curso) VALUES (?,?)";
    private String leer = "SELECT * FROM cursos WHERE cod_curso=?";
    private String actualizar = "UPDATE cursos SET cod_curso=?, nomb_curso=? WHERE (cod_curso=?)";
    private String borrar = "DELETE FROM cursos WHERE (cod_curso=?)";
    private String verTabla = "SELECT * FROM cursos";
    
    
public CursoDao() throws ClassNotFoundException {
    conex= Connect2Db.getInstance().getConnection();
    curso = new Curso();
    cursos = new ArrayList();
}

    @Override
    public boolean createRecord(Curso model) {
        try {
            preQuery = conex.prepareStatement(insertar);
            preQuery.setInt(1, model.getCodigo());
            preQuery.setString(2, model.getNombre());
                       
            if (preQuery.executeUpdate() >0) {
            isSuccesfully = true;
        }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSuccesfully;
    }

    @Override
    public Curso readRecord(Integer idModel) {
       try {
           preQuery=conex.prepareStatement(leer);
           preQuery.setInt(1, idModel);
           ResultSet data = preQuery.executeQuery();
           
           if (data.next()) {
               curso.setCodigo(data.getInt("cod_curso"));
               curso.setNombre(data.getString("nomb_curso"));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return curso;
    }

    @Override
    public boolean updateRecord(Curso model, Integer idModel) {
        try {
            preQuery = conex.prepareStatement(actualizar);
            preQuery.setInt(1, model.getCodigo());
            preQuery.setString(2, model.getNombre());
            preQuery.setInt(3, idModel);
            
            if (preQuery.executeUpdate()>0) {
                isSuccesfully = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public List<Curso> readRecords() {
        try {
            preQuery = conex.prepareStatement(verTabla);
            ResultSet data = preQuery.executeQuery();
            
            while (data.next()) {
                cursos.add(new Curso(data.getInt("cod_curso"), data.getString("nomb_curso")));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursos;
    }    
}