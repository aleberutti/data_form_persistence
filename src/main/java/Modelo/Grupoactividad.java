package Modelo;
// Generated 25-sep-2019 10:57:58 by Hibernate Tools 4.3.1



/**
 * Grupoactividad generated by hbm2java
 */
public class Grupoactividad  implements java.io.Serializable {


     private char idGrupo;
     private String nombreGrupo;

    public Grupoactividad() {
    }

    public Grupoactividad(char idGrupo, String nombreGrupo) {
       this.idGrupo = idGrupo;
       this.nombreGrupo = nombreGrupo;
    }
   
    public char getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(char idGrupo) {
        this.idGrupo = idGrupo;
    }
    public String getNombreGrupo() {
        return this.nombreGrupo;
    }
    
    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }




}


