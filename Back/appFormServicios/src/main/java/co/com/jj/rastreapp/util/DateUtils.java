/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author jeio
 */
public class DateUtils {

    private static DateUtils dateUtils = null;

    private DateUtils() {

    }

    public static DateUtils getInstance() {
        if (dateUtils == null) {
            dateUtils = new DateUtils();
        }
        return dateUtils;
    }
    
    public java.sql.Timestamp getFechaActual(){
        Date date = new Date();
        java.sql.Timestamp fechaActual = new  Timestamp(date.getTime());
        return fechaActual;
    }

}
