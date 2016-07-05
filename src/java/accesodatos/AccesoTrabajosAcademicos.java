
package accesodatos;

import db.HibernateUtil;
import entidades.CongrTrabajoAcademico;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import utilitario.FechaUtil;

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
    
}
