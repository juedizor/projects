/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.vo;

import java.io.Serializable;


public class CiudadVO implements Serializable {

    private String codigoCiudad;
    private String nombreCiudad;

    public CiudadVO() {
    }

    public CiudadVO(String codigoCiudad, String nombreCiudad) {
        this.codigoCiudad = codigoCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
}