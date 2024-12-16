/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearTablas;

import dbConections.Connect2Db;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author estudiante
 */
public class TablasH2 implements CrearTablas{
    
    private static Connection conexConnection;
    
    String tProfesores = "CREATE TABLE IF NOT EXISTS profesores (\n"
    +"id_prof INTEGER PRIMARY KEY,\n"
    +"dni_prof VARCHAR(10) NOT NULL,\n"
    +"nom_prof VARCHAR(15) NOT NULL,\n"
    +"ape_prof VARCHAR(15) NOT NULL,\n"
    +"naci_prof VARCHAR(15),\n"
    +"cpostal_prof INTEGER,\n"
    +"tfn_prof INTEGER\n"
    +");";

    String tAlumnos = "CREATE TABLE IF NOT EXISTS alumnos (\n"
    +"id_alum INTEGER PRIMARY KEY,\n"
    +"dni_alum VARCHAR(10) NOT NULL, \n"
    +"nom_alum VARCHAR(15) NOT NULL,\n"
    +"ape_alum VARCHAR(15) NOT NULL,\n"
    +"naci_alum VARCHAR(15),\n"
    +"cpostal_alum INTEGER,\n"
    +"tfn_alum INTEGER\n"
    +");";

    String tAsignaturas = "CREATE TABLE IF NOT EXISTS asignaturas (\n"
    +"cod_asig INTEGER PRIMARY KEY,\n"
    +"nomb_asig VARCHAR(15) NOT NULL,\n"
    +"horas INTEGER\n"
    +");";

    String tAulas = "CREATE TABLE IF NOT EXISTS aulas (\n"
    +"cod_aula INTEGER PRIMARY KEY,\n"
    +"piso INTEGER NOT NULL,\n"
    +"num_pupitres INTEGER\n"
    +");";

    String tCursos = "CREATE TABLE IF NOT EXISTS cursos (\n"
    +"cod_curso INTEGER PRIMARY KEY,\n"
    +"nomb_curso VARCHAR(15) NOT NULL\n"
    +");";
    
    String tUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (\n"
    +"id_user INTEGER PRIMARY KEY,\n"
    +"nomb_user VARCHAR(15) NOT NULL,\n"
    +"pass_user VARCHAR(15) NOT NULL\n"
    +");";
    
    @Override
    public void crearTablas()throws ClassNotFoundException {
        try {
            conexConnection = Connect2Db.getInstance().getConnection();
            Statement stmt = conexConnection.createStatement();
            stmt.execute(tProfesores);
            stmt.execute(tAlumnos);
            stmt.execute(tAsignaturas);
            stmt.execute(tAulas);
            stmt.execute(tCursos);
            stmt.execute(tUsuarios);
        } catch (SQLException ex) {
            
        }

    }
}
