package entidades;
// Generated 27/06/2016 06:34:06 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * SegRol generated by hbm2java
 */
public class SegRol  implements java.io.Serializable {


     private BigDecimal idRol;
     private AdmModuloSistema admModuloSistema;
     private String nombreRol;
     private String descripcion;
     private Set segPermisos = new HashSet(0);
     private Set segUsuarios = new HashSet(0);

    public SegRol() {
    }

	
    public SegRol(BigDecimal idRol, AdmModuloSistema admModuloSistema, String nombreRol, String descripcion) {
        this.idRol = idRol;
        this.admModuloSistema = admModuloSistema;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
    }
    public SegRol(BigDecimal idRol, AdmModuloSistema admModuloSistema, String nombreRol, String descripcion, Set segPermisos, Set segUsuarios) {
       this.idRol = idRol;
       this.admModuloSistema = admModuloSistema;
       this.nombreRol = nombreRol;
       this.descripcion = descripcion;
       this.segPermisos = segPermisos;
       this.segUsuarios = segUsuarios;
    }
   
    public BigDecimal getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(BigDecimal idRol) {
        this.idRol = idRol;
    }
    public AdmModuloSistema getAdmModuloSistema() {
        return this.admModuloSistema;
    }
    
    public void setAdmModuloSistema(AdmModuloSistema admModuloSistema) {
        this.admModuloSistema = admModuloSistema;
    }
    public String getNombreRol() {
        return this.nombreRol;
    }
    
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getSegPermisos() {
        return this.segPermisos;
    }
    
    public void setSegPermisos(Set segPermisos) {
        this.segPermisos = segPermisos;
    }
    public Set getSegUsuarios() {
        return this.segUsuarios;
    }
    
    public void setSegUsuarios(Set segUsuarios) {
        this.segUsuarios = segUsuarios;
    }




}


