package Modelo;
// Generated 25-sep-2019 10:57:58 by Hibernate Tools 4.3.1



/**
 * Subproducto generated by hbm2java
 */
public class Subproducto  implements java.io.Serializable {


     private Integer idSubProducto;
     private String nombre;
     private String estadoFisico;
     private double produccionAnual;
     private String unidad;
     private String almacenamiento;
     private int idPlanta;

    public Subproducto() {
    }

    public Subproducto(String nombre, String estadoFisico, double produccionAnual, String unidad, String almacenamiento, int idPlanta) {
       this.nombre = nombre;
       this.estadoFisico = estadoFisico;
       this.produccionAnual = produccionAnual;
       this.unidad = unidad;
       this.almacenamiento = almacenamiento;
       this.idPlanta = idPlanta;
    }
   
    public Integer getIdSubProducto() {
        return this.idSubProducto;
    }
    
    public void setIdSubProducto(Integer idSubProducto) {
        this.idSubProducto = idSubProducto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEstadoFisico() {
        return this.estadoFisico;
    }
    
    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }
    public double getProduccionAnual() {
        return this.produccionAnual;
    }
    
    public void setProduccionAnual(double produccionAnual) {
        this.produccionAnual = produccionAnual;
    }
    public String getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    public String getAlmacenamiento() {
        return this.almacenamiento;
    }
    
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
    public int getIdPlanta() {
        return this.idPlanta;
    }
    
    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }




}

