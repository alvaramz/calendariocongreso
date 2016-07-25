package accesodatos;

import db.HibernateUtil;
import entidades.CongrAutor;
import entidades.CongrTrabajoAcademico;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Adrián Alvarado Ramírez
 */
public class AccesoAutores {

    public List<CongrAutor> obtenerAutores(String filtro) {
        List<CongrAutor> autores = new ArrayList<>();

        Session session;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query q;
            if (filtro == null) {
                q = session.createQuery("from CongrAutor order by apellidos");
            } else {
                filtro = filtro.toUpperCase();
                q = session.createQuery("from CongrAutor where apellidos LIKE :filtro or nombre LIKE :filtro order by apellidos");
                q.setParameter("filtro", "%" + filtro + "%");
            }

            autores = (List<CongrAutor>) q.list();

            for (CongrAutor autor : autores) {
                Hibernate.initialize(autor.getCongrTrabajoAcademicos());                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return autores;
    }

}
