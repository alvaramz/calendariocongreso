
package accesodatos;

import db.HibernateUtil;
import entidades.CongrTrabajoAcademico;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author adrian
 */
public class AccesoTrabajosAcademicos {
    
    
     public List<CongrTrabajoAcademico> obtenerTrabajosAcademicos(BigDecimal idSesion) {
        List<CongrTrabajoAcademico> trabajosAcademicos = new ArrayList<>();

        Session session;
        session = HibernateUtil.getSessionFactory().openSession();

        try {          
            Query q = session.createQuery("from CongrTrabajoAcademico where congrSesion.idSesion = :idSesion");
            q.setParameter("idSesion", idSesion);
            trabajosAcademicos = (List<CongrTrabajoAcademico>) q.list();

            for (CongrTrabajoAcademico trabajo : trabajosAcademicos) {                
                Hibernate.initialize(trabajo.getCongrEjeTematico());               
                Hibernate.initialize(trabajo.getCongrTipoTrabajoAcademico());               
                Hibernate.initialize(trabajo.getCongrAutors());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return trabajosAcademicos;
    }
     
    public CongrTrabajoAcademico obtenerTrabajoAcademico(BigDecimal idTrabajoAcademico){
        CongrTrabajoAcademico trabajoAcademico = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();

        try {          
            Query q = session.createQuery("from CongrTrabajoAcademico where idTrabajoAcademico = :idTrabajoAcademico");
            q.setParameter("idTrabajoAcademico", idTrabajoAcademico);
            trabajoAcademico = (CongrTrabajoAcademico) q.uniqueResult();

            Hibernate.initialize(trabajoAcademico.getCongrSesion());
            Hibernate.initialize(trabajoAcademico.getCongrSesion().getCongrSala());
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return trabajoAcademico;
    }
    
}
