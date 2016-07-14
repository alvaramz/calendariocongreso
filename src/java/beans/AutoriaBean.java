package beans;

import accesodatos.AccesoAutores;
import entidades.CongrAutor;
import entidades.CongrTrabajoAcademico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Bean para la página de la autoría.
 *
 * @author Adrián Alvarado Ramírez
 */
@ManagedBean
@ViewScoped
public class AutoriaBean implements Serializable{

    private List<CongrAutor> listaAutores;
    private String textoBuscar;

    public AutoriaBean() {

        AccesoAutores accesoAutores = new AccesoAutores();
        listaAutores = accesoAutores.obtenerAutores(null);

    }

    public List<CongrTrabajoAcademico> obtenerTrabajosAcademicos(CongrAutor autor) {
        List<CongrTrabajoAcademico> trabajosAcademicos = new ArrayList<>();

        for (Object trabajo : autor.getCongrTrabajoAcademicos()) {
            trabajosAcademicos.add((CongrTrabajoAcademico) trabajo);
        }

        return trabajosAcademicos;
    }

    public void buscar() {
       
            AccesoAutores accesoAutores = new AccesoAutores();
            listaAutores = accesoAutores.obtenerAutores(textoBuscar);
        
    }

    /**
     * @return the listaAutores
     */
    public List<CongrAutor> getListaAutores() {
        return listaAutores;
    }

    /**
     * @param listaAutores the listaAutores to set
     */
    public void setListaAutores(List<CongrAutor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    /**
     * @return the textoBuscar
     */
    public String getTextoBuscar() {
        return textoBuscar;
    }

    /**
     * @param textoBuscar the textoBuscar to set
     */
    public void setTextoBuscar(String textoBuscar) {
        this.textoBuscar = textoBuscar;
    }
}
