/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import interfazDao.IDao;
import modelosDao.AlumnoDao;
import modelosDao.AsignaturaDao;
import modelosDao.AulaDao;
import modelosDao.CursoDao;
import modelosDao.ProfesorDao;
import modelosDao.UsuarioDao;


/**
 *
 * @author estudiante
 */
public class DaoFactory {
    
    public enum DaoType {
        PROFESOR, ALUMNO, CURSO, ASIGNATURA, AULA, USUARIO
    }
    
    public static IDao getDao ( DaoType daoType) throws ClassNotFoundException {
        IDao dao = null;
        switch (daoType) {
            case PROFESOR:
                dao = new ProfesorDao();
                
                break;
            case ALUMNO: 
                dao = new AlumnoDao();
                
                break;
                
            case CURSO: 
                dao = new CursoDao();
                
                break;
                
            case ASIGNATURA: 
                dao = new AsignaturaDao();
                
                break;
                
            case AULA: 
                dao = new AulaDao();
                
                break;
                
            case USUARIO:
                dao = new UsuarioDao();
                
                break;
             
        }
        return dao;
    }
    
}
