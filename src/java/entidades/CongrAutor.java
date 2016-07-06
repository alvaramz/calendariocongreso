package entidades;
// Generated 04/07/2016 10:19:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * CongrAutor generated by hbm2java
 */
public class CongrAutor  implements java.io.Serializable {


     private BigDecimal idAutor;
     private String nombre;
     private String apellidos;
     private String codigoNacion;
     private String correoElectronico;
     private Set congrTrabajoAcademicos = new HashSet(0);

    public CongrAutor() {
    }

	
    public CongrAutor(BigDecimal idAutor, String nombre, String apellidos, String codigoNacion) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigoNacion = codigoNacion;
    }
    public CongrAutor(BigDecimal idAutor, String nombre, String apellidos, String codigoNacion, String correoElectronico, Set congrTrabajoAcademicos) {
       this.idAutor = idAutor;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.codigoNacion = codigoNacion;
       this.correoElectronico = correoElectronico;
       this.congrTrabajoAcademicos = congrTrabajoAcademicos;
    }
   
    public BigDecimal getIdAutor() {
        return this.idAutor;
    }
    
    public void setIdAutor(BigDecimal idAutor) {
        this.idAutor = idAutor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCodigoNacion() {
        return this.codigoNacion;
    }
    
    public void setCodigoNacion(String codigoNacion) {
        this.codigoNacion = codigoNacion;
    }
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public Set getCongrTrabajoAcademicos() {
        return this.congrTrabajoAcademicos;
    }
    
    public void setCongrTrabajoAcademicos(Set congrTrabajoAcademicos) {
        this.congrTrabajoAcademicos = congrTrabajoAcademicos;
    }




}

