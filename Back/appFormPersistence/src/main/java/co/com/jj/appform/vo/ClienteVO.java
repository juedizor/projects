/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.vo;

/**
 *
 * @author jeio
 */
public class ClienteVO {

    private Integer codigo_tipo_documento_cliente;
    private Long numeroDocumentoCliente;
    private Integer codigoTipoDocumento;
    private Long numeroDocumento;

    public Integer getCodigo_tipo_documento_cliente() {
        return codigo_tipo_documento_cliente;
    }

    public void setCodigo_tipo_documento_cliente(Integer codigo_tipo_documento_cliente) {
        this.codigo_tipo_documento_cliente = codigo_tipo_documento_cliente;
    }

    public Long getNumeroDocumentoCliente() {
        return numeroDocumentoCliente;
    }

    public void setNumeroDocumentoCliente(Long numeroDocumentoCliente) {
        this.numeroDocumentoCliente = numeroDocumentoCliente;
    }

    public Integer getCodigoTipoDocumento() {
        return codigoTipoDocumento;
    }

    public void setCodigoTipoDocumento(Integer codigoTipoDocumento) {
        this.codigoTipoDocumento = codigoTipoDocumento;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    
    

    
}
