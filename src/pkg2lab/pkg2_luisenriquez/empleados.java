/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2lab.pkg2_luisenriquez;

/**
 *
 * @author Luis Enriquez
 */
public class empleados {
    
    String nombre, apellido, kolor, titulo, genero;
    int edad, cargo;
    double altura, peso, sueldo;
    

    public empleados() {
        
    }
    
    public empleados(String nom, String ap, String kol, int ed, char g, double alt, double pes, String tit, int carg) {
        nombre = nom;
        apellido = ap;
        kolor = kol;
        edad = ed;
        
        if (g == 'm') {
            genero = "Masculino";
        }else{
            genero = "Femenino";
        }
        
        altura = alt;
        peso = pes;
        titulo = tit;
        
        cargo = carg;
        
        if (cargo == 1) {
            sueldo = 500000;
        }
        if (cargo == 2) {
            sueldo = 300000;
        }
        if (cargo == 3) {
            sueldo = 400000;
        }
        if (cargo == 4) {
            sueldo = 380000;
        }
             
        
    }
    
    public void setNombre (String n ) {
        nombre = n;
    }
    
    public void setApellido (String n ) {
        nombre = n;
    }
    
    public void setColor (String n ) {
        nombre = n;
    }
    
    public void setEdad (int n) {
        edad = n;
    }
    
    public void setGenero (char n) {
        if (n == 'm' || n == 'M') {
            genero = "Masculino";
        }else{
            genero = "Femenino";
        }
    }
    
    public void setAltura (double n) {
        altura = n;
    }
    
    public void setPeso (double n) {
        peso = n;
    }
    
    public void setTitulo (String n) {
        titulo = n;
    }
    
    public void setSueldo( double n) {
        sueldo = n;
    }
    
    public void setCargo(int c) {
        cargo = c;
    }
    
    public int getCargo() {
        return cargo;
    }
    
    public String toString () {
        return cargo + " " + nombre + " " + apellido + " L. " + sueldo;
    }
    
    
}
