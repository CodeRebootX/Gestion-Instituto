/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author estudiante
 */
public class Asignatura  implements Entidad{
    private int codigo;
    private String nombre;
    private int horas;

    public Asignatura(int codigo, String nombre, int horas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horas = horas;
    }
    

    public Asignatura(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public Asignatura () {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "codigo=" + codigo + ", nombre=" + nombre + ", horas=" + horas + '}';
    }
    
    @Override
    public String [] toArrayString () {
        String[] s = new String [3];
        s[0]=String.valueOf(codigo);
        s[1]=nombre;
        s[2]=String.valueOf(horas);
    
        return s; 
    }
    
    
    
}
