/*
 * Elaborado para la Unidad de Tecnologías de Información del Instituto de Investigación en Educación, de la U.C.R
 * Elaborado por Adrián Alvarado Ramírez.
 * Correo electrónico: a.alvarado.r@gmail.com
 */
package accesodatos;

import db.HibernateUtil;
import entidades.CongrSesion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import utilitario.FechaUtil;

/**
 * Provee la funcionalidad para leer las sesiones.
 *
 * @author Adrián Alvarado Ramírez.
 */
public class AccesoCalendario {

    public List<CongrSesion> obtenerSesiones(int dia) {
        List<CongrSesion> sesiones = null;

        switch (dia) {
            case 26:
                sesiones = obtenerSesiones("26/07/2016","27/07/2016");
                break;
            case 27:
                sesiones = obtenerSesiones("27/07/2016","28/07/2016");
                break;
            case 28:
                sesiones = obtenerSesiones("28/07/2016","29/07/2016");
                break;
            default:
                System.out.println("Día inválido");
        }

        return sesiones;
    }

    private List<CongrSesion> obtenerSesiones(String fechaInicialS, String fechaFinalS) {
        List<CongrSesion> sesiones = new ArrayList<>();

        Session session;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Date fechaInicial = FechaUtil.convertirFecha(fechaInicialS);
            Date fechaFinal = FechaUtil.convertirFecha(fechaFinalS);
            Query q = session.createQuery("from CongrSesion where fechaDesde >= :fechaInicial and fechaHasta < :fechaFinal order by fechaDesde asc");
            q.setDate("fechaInicial", fechaInicial);
            q.setDate("fechaFinal", fechaFinal);
            sesiones = (List<CongrSesion>) q.list();

            for (CongrSesion congreso : sesiones) {
                Hibernate.initialize(congreso.getCongrModerador());
                Hibernate.initialize(congreso.getCongrSala());
                Hibernate.initialize(congreso.getCongrTrabajoAcademicos());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return sesiones;
    }   

}
