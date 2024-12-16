/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author estudiante
 */
public class Profesor implements Entidad {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String nacimiento;
    private int cod_postal;
    private int telefono;

    public Profesor() {
        
    }

    public Profesor(int id, String dni, String nombre, String apellido, String nacimiento, int cod_postal, int telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.cod_postal = cod_postal;
        this.telefono = telefono;
    }

    public Profesor(int id, String dni, String nombre, String apellido) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", nacimiento=" + nacimiento + ", cod_postal=" + cod_postal + ", telefono=" + telefono + '}';
    }
    
    @Override
    public String [] toArrayString () {
        String[] s = new String [7];
        s[0]=String.valueOf(id);
        s[1]=dni;
        s[2]=nombre;
        s[3]=apellido;
        s[4]=nacimiento;
        s[5]=String.valueOf(cod_postal);
        s[6]=String.valueOf(telefono);
        
        return s;
        
    }
    
    
    
    
}
