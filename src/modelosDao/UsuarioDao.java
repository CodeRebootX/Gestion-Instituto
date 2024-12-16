/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDao;

import dbConections.Connect2Db;
import interfazDao.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;

/**
 *
 * @author rolan
 */
public class UsuarioDao implements IDao<Usuario, Integer> {
    private Connection conex;
    private PreparedStatement preQuery;
    private boolean isSuccesfully = false;
    private Usuario user;
    private List<Usuario> usuarios;
    private String insertar = "INSERT INTO usuarios (id_user, nomb_user, pass_user) VALUES (?,?,?)";
    private String leer = "SELECT * FROM usuarios WHERE nombre_user=?";
    private String actualizar = "UPDATE usuarios SET id_user=?, nomb_user=?, pass_user=? WHERE (id_user=?)";
    private String borrar = "DELETE FROM usuarios WHERE (id_user=?)";
    private String verTabla = "SELECT * FROM usuarios";
    
    
public UsuarioDao() throws ClassNotFoundException {
    conex= Connect2Db.getInstance().getConnection();
    user = new Usuario();
    usuarios = new ArrayList();
}

    @Override
    public boolean createRecord(Usuario model) {
        try {
            preQuery = conex.prepareStatement(insertar);
            preQuery.setInt(1, model.getId());
            preQuery.setString(2, model.getNombre());
            preQuery.setString(3, model.getPassword());
            
                       
            if (preQuery.executeUpdate() >0) {
            isSuccesfully = true;
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSuccesfully;
    }

    @Override
    public Usuario readRecord(Integer idModel) {
       try {
           preQuery=conex.prepareStatement(leer);
           preQuery.setInt(1, idModel);
           ResultSet data = preQuery.executeQuery();
           
           if (data.next()) {
               user.setId(data.getInt("id_user"));
               user.setNombre(data.getString("nomb_user"));
               user.setPassword(data.getString("pass_user"));
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return user;
    }

    @Override
    public boolean updateRecord(Usuario model, Integer idModel) {
        try {
            preQuery = conex.prepareStatement(actualizar);
            preQuery.setInt(1, model.getId());
            preQuery.setString(2, model.getNombre());
            preQuery.setString(3, model.getPassword());
            preQuery.setInt(4, idModel);
            
            if (preQuery.executeUpdate()>0) {
                isSuccesfully = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccesfully;
    }

    @Override
    public List<Usuario> readRecords() {
        try {
            preQuery = conex.prepareStatement(verTabla);
            ResultSet data = preQuery.executeQuery();
            
            while (data.next()) {
                usuarios.add(new Usuario(data.getInt("id_user"), data.getString("nomb_user"), data.getString("pass_user")));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }    
}

    

