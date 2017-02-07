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
public class TelefonoSedeVO {

    private Integer idTelefonoSede;
    private String codigoSede;
    private String numeroTelefeno;
    private java.sql.Timestamp fechaRegistro;

    public Integer getIdTelefonoSede() {
        return idTelefonoSede;
    }

    public void setIdTelefonoSede(Integer idTelefonoSede) {
        this.idTelefonoSede = idTelefonoSede;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNumeroTelefeno() {
        return numeroTelefeno;
    }

    public void setNumeroTelefeno(String numeroTelefeno) {
        this.numeroTelefeno = numeroTelefeno;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    

    
}
