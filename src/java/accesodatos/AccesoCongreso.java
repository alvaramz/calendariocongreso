/*
 * Elaborado para la Unidad de Tecnologías de Información del Instituto de Investigación en Educación, de la U.C.R
 * Elaborado por Adrián Alvarado Ramírez.
 * Correo electrónico: a.alvarado.r@gmail.com
 */
package accesodatos;

import db.HibernateUtil;
import entidades.CongrCongreso;
import java.math.BigDecimal;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Provee la funcionalidad para cargar la información del Congreso.
 * @author Adrián Alvarado Ramírez
 */
public class AccesoCongreso {
    
    
    public CongrCongreso obtenerCongreso(int id){
        BigDecimal idCongreso = new BigDecimal(id);
        CongrCongreso congreso = null;
        
          Session sesion;
        sesion = HibernateUtil.getSessionFactory().openSession();

        try {
            Query q = sesion.createQuery("from CongrCongreso where idCongreso = :pId");
            q.setParameter("pId", idCongreso);
            congreso = (CongrCongreso) q.uniqueResult();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        sesion.close();
        
        return congreso;
    }
    
}
