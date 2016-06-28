/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author adrian
 */
public class FechaUtil {

    /**
     * Convierte un literal alfanumérico que contiene una fecha con formato "dd/MM/yyyy" a un objeto de tipo Date. Si la fecha está mal formateada, o fuera de rango,
     * se retorna un null.
     * @param fechaS El literal alfanumérico que contiene la fecha con formato dd/MM/yyyy
     */
    public static Date convertirFecha(String fechaS) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = sdf.parse(fechaS);
            return fecha;
        } catch (ParseException pe) {
            return null;
        }
    }

}
