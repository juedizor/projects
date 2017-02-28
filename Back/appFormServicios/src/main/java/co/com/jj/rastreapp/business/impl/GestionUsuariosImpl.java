/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.persistence.daofactory.CreateInstance;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.appform.persistence.iface.generics.TransactionIface;
import co.com.jj.appform.vo.UsuarioVO;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;
import co.com.jj.rastreapp.dto.factory.CreateDTO;
import co.com.jj.rastreapp.dto.factory.createdto.CreateUsuarioDTO;
import co.com.jj.rastreapp.util.DateUtils;

/**
 *
 * @author jeio
 */
@Service
public class GestionUsuariosImpl implements GestionUsuariosIface {

    @Autowired
    UsuarioIfaceDAO usuarioIfaceDAO;
    @Autowired
    PersonaIfaceDAO personaIfaceDAO;
    @Autowired
    TransactionIface transactionIface;
//    @Autowired
//    PersonaIfaceDAO personaIfaceDAO;
//    @Autowired
//    TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
//    @Autowired
//    PerfilIfaceDAO perfilIfaceDAO;
//    @Autowired
//    EmpresaIfaceDAO empresaIfaceDAO;
//    @Autowired
//    DireccionIfaceDAO direccionIfaceDAO;

    private static final DateUtils DATE_UTILS = DateUtils.getInstance();

    @Override
    public UsuarioDTO getUserActivo(String nombreUsuario, String contrasena) throws Exception {
        List<UsuarioVO> lisUsuarioVOs = usuarioIfaceDAO.findByNombreUsuarioContrasena(nombreUsuario, contrasena);
        if (lisUsuarioVOs != null && !lisUsuarioVOs.isEmpty()) {
            CreateDTO<UsuarioDTO> instance = new CreateDTO<>();
            UsuarioDTO usuarioDTO = instance.createInstance(CreateUsuarioDTO.getInstance());
            usuarioDTO.setNombreUsuario(lisUsuarioVOs.get(0).getNombreUsuario());
            usuarioDTO.setActivo(lisUsuarioVOs.get(0).isActivo());
            return usuarioDTO;
        }
        return null;
    }

    @Override
    public UsuarioDTO getUser(String nombreUsuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioDTO> obtenerUsuarios(String nombreUsuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(UsuarioDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(UsuarioDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
