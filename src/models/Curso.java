/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author estudiante
 */
public class Curso implements Entidad {
    private int codigo;
    private String nombre;

    public Curso(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public Curso () {
        
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

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    @Override
    public String [] toArrayString () {
        String[] s = new String [2];
        s[0] = String.valueOf(codigo);
        s[1] = nombre;
    
        return s; 
    }
}
