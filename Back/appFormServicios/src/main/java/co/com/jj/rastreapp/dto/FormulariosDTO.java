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
public class FormulariosDTO {
    
    private Integer idFormulario;
    private String xmlForm;

    public FormulariosDTO() {
    }

    public FormulariosDTO(Integer idFormulario, String xmlForm) {
        this.idFormulario = idFormulario;
        this.xmlForm = xmlForm;
    }

    public String getXmlForm() {
        return xmlForm;
    }

    public void setXmlForm(String xmlForm) {
        this.xmlForm = xmlForm;
    }

    public Integer getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }
    
    
    
    
    
    
}
