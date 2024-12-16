/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author estudiante
 */
public class Aula implements Entidad {
    private int codigo;
    private int piso;
    private int num_pupitres;

    public Aula(int codigo, int piso, int num_pupitres) {
        this.codigo = codigo;
        this.piso = piso;
        this.num_pupitres = num_pupitres;
    }

    
    
    public Aula(int codigo, int piso) {
        this.codigo = codigo;
        this.piso = piso;
    }
    
    public Aula () {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNum_pupitres() {
        return num_pupitres;
    }

    public void setNum_pupitres(int num_pupitres) {
        this.num_pupitres = num_pupitres;
    }

    @Override
    public String toString() {
        return "Aula{" + "codigo=" + codigo + ", piso=" + piso + ", num_pupitres=" + num_pupitres + '}';
    }
    
    @Override
    public String [] toArrayString () {
        String[] s = new String [3];
        s[0] = String.valueOf(codigo);
        s[1] = String.valueOf(piso);
        s[2] = String.valueOf(num_pupitres);
    
        return s; 
    }
       
}
