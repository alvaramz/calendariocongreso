/*
 * Elaborado para la Unidad de Tecnologías de Información del Instituto de Investigación en Educación, de la U.C.R
 * Elaborado por Adrián Alvarado Ramírez.
 * Correo electrónico: a.alvarado.r@gmail.com
 */
package beans;

import accesodatos.AccesoCalendario;
import accesodatos.AccesoCongreso;
import accesodatos.AccesoTrabajosAcademicos;
import entidades.CongrCongreso;
import entidades.CongrSesion;
import entidades.CongrTrabajoAcademico;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Bean para la página del calendario, la página inicial
 *
 * @author Adrián Alvarado Ramírez
 */
@ManagedBean(name = "calendarioBean")
@RequestScoped
public class CalendarioBean implements Serializable {
    
    // Datos estáticos.
    int ID_CONGRESO = 1;

    // Atributos
    // Origenes de Datos
    private List<CongrSesion> listaSesiones26;
    private List<CongrSesion> listaSesiones27;
    private List<CongrSesion> listaSesiones28;
    private CongrCongreso congreso;
    
    private CongrSesion sesionSeleccionada;

    // Objetos para Acceder a datos.
    private AccesoCalendario accesoCalendario;

    public CalendarioBean() {
        accesoCalendario = new AccesoCalendario();

        listaSesiones26 = accesoCalendario.obtenerSesiones(26);
        listaSesiones27 = accesoCalendario.obtenerSesiones(27);
        listaSesiones28 = accesoCalendario.obtenerSesiones(28);
        cargarCongreso();
    }
    
    private void cargarCongreso(){
        AccesoCongreso accesoCongreso = new AccesoCongreso();
        congreso = accesoCongreso.obtenerCongreso(ID_CONGRESO);
    }
    
    public List<CongrTrabajoAcademico> getTrabajosAcademicos(){
        if(sesionSeleccionada != null){
            return new AccesoTrabajosAcademicos().obtenerTrabajosAcademicos(sesionSeleccionada.getIdSesion());
        }else{
            return null;
        }
    }

    /**
     * @return the listaSesiones26
     */
    public List<CongrSesion> getListaSesiones26() {
        return listaSesiones26;
    }

    /**
     * @param listaSesiones26 the listaSesiones26 to set
     */
    public void setListaSesiones26(List<CongrSesion> listaSesiones26) {
        this.listaSesiones26 = listaSesiones26;
    }

    /**
     * @return the listaSesiones27
     */
    public List<CongrSesion> getListaSesiones27() {
        return listaSesiones27;
    }

    /**
     * @param listaSesiones27 the listaSesiones27 to set
     */
    public void setListaSesiones27(List<CongrSesion> listaSesiones27) {
        this.listaSesiones27 = listaSesiones27;
    }

    /**
     * @return the listaSesiones28
     */
    public List<CongrSesion> getListaSesiones28() {
        return listaSesiones28;
    }

    /**
     * @param listaSesiones28 the listaSesiones28 to set
     */
    public void setListaSesiones28(List<CongrSesion> listaSesiones28) {
        this.listaSesiones28 = listaSesiones28;
    }

    /**
     * @return the congreso
     */
    public CongrCongreso getCongreso() {
        return congreso;
    }

    /**
     * @param congreso the congreso to set
     */
    public void setCongreso(CongrCongreso congreso) {
        this.congreso = congreso;
    }

    /**
     * @return the sesionSeleccionada
     */
    public CongrSesion getSesionSeleccionada() {
        return sesionSeleccionada;
    }

    /**
     * @param sesionSeleccionada the sesionSeleccionada to set
     */
    public void setSesionSeleccionada(CongrSesion sesionSeleccionada) {
        this.sesionSeleccionada = sesionSeleccionada;
    }

  

}
