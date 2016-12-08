/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.iface;

import co.com.jj.rastreapp.dto.FormulariosDTO;
import java.util.List;

/**
 *
 * @author jeio
 */
public interface GestionFormulariosIface {
    
    public List<FormulariosDTO> getFormularioPorPerfil(int idPerfil);
    public boolean guardarFormulario(FormulariosDTO formulariosDTO);
    public boolean actualizarFormulario(FormulariosDTO formulariosDTO);
}
