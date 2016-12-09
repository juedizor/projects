/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.dto;

/**
 *
 * @author jeio
 */
public class TipoDocumentoDTO {
    
    private Integer idTipoDocumento;
    private String codigo;
    private String nombre;

    public TipoDocumentoDTO() {
    }

    public TipoDocumentoDTO(Integer idTipoDocumento, String codigo, String nombre) {
        this.idTipoDocumento = idTipoDocumento;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
