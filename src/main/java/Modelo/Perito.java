package Modelo;
// Generated 25-sep-2019 10:57:58 by Hibernate Tools 4.3.1



/**
 * Perito generated by hbm2java
 */
public class Perito  implements java.io.Serializable {


     private int nroRegistro;
     private String apellido;
     private String nombre;
     private String profesion;

    public Perito() {
    }

    public Perito(int nroRegistro, String apellido, String nombre, String profesion) {
       this.nroRegistro = nroRegistro;
       this.apellido = apellido;
       this.nombre = nombre;
       this.profesion = profesion;
    }
   
    public int getNroRegistro() {
        return this.nroRegistro;
    }
    
    public void setNroRegistro(int nroRegistro) {
        this.nroRegistro = nroRegistro;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getProfesion() {
        return this.profesion;
    }
    
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }




}


