/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
import co.com.jj.appform.persistence.iface.EmpresaIfaceDAO;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionEmpresasIface;
import co.com.jj.rastreapp.dto.EmpresaDTO;
import co.com.jj.rastreapp.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julio.izquierdo
 */
@Service
public class GestionEmpresasImpl implements GestionEmpresasIface {

    @Autowired
    UsuarioIfaceDAO usuarioIfaceDAO;
    @Autowired
    PersonaIfaceDAO personaIfaceDAO;
    @Autowired
    TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
    @Autowired
    PerfilIfaceDAO perfilIfaceDAO;
    @Autowired
    EmpresaIfaceDAO empresaIfaceDAO;
    @Autowired
    DireccionIfaceDAO direccionIfaceDAO;

    private static final DateUtils DATE_UTILS = DateUtils.getInstance();

    @Override
    public int registrarEmpresa(EmpresaDTO empresaDTO) throws Exception {
        
        return Respuestas.ERROR;
    }

    @Override
    public int actualizarEmpresa(EmpresaDTO empresaDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
