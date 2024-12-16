/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import crearTablas.TablasH2;
import crearTablas.CrearTablas;



/**
 *
 * @author estudiante
 */
public class DbFactory {
    
    public static CrearTablas getFactory (String DbType) {
        if ("H2".equals(DbType)) {
            System.out.println("¡Tablas creadas!");
            return new TablasH2();
        }
        System.out.println("¡No se ha podido crear las tablas!");
        return null;
    }
    
}
