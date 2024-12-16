/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class Connect2Db {
    private static Connect2Db connectInstance;
    private Connection conexConnection;
    private final String URL = "jdbc:h2:/home/estudiante/Documentos/DAM2/ACCESO DATOS/DataBase/H2/Academy";
    
    private Connect2Db () throws ClassNotFoundException {
        try{
            conexConnection= DriverManager.getConnection(URL);
            System.out.println("Conectado!");
        } catch (SQLException ex) {
            Logger.getLogger(Connect2Db.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("OK ");
        }
        
    }
    
    public static Connect2Db getInstance() throws ClassNotFoundException {
        if (connectInstance == null) {
            connectInstance = new Connect2Db();
        }
        return connectInstance;
    }
    
    public Connection getConnection() {
        return conexConnection;
    }
    
}
