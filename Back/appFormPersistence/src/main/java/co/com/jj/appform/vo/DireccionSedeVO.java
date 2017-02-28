/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.vo;

import java.sql.Timestamp;

/**
 *
 * @author jeio
 */
public class DireccionSedeVO {

    private Integer idDireccionSede;
    private String codigoSede;
    private String nombreDireccionSede;
    private java.sql.Timestamp fechaRegistro;
    private java.sql.Timestamp fechaModificacion;

    public Integer getIdDireccionSede() {
        return idDireccionSede;
    }

    public void setIdDireccionSede(Integer idDireccionSede) {
        this.idDireccionSede = idDireccionSede;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombreDireccionSede() {
        return nombreDireccionSede;
    }

    public void setNombreDireccionSede(String nombreDireccionSede) {
        this.nombreDireccionSede = nombreDireccionSede;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    

    
}
