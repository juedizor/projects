/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.appformtransaction.iface.TransactionIface;
import co.com.jj.appform.cloneclasstoclass.CopyClassIface;
import co.com.jj.appform.cloneclasstoclass.CopyClassImpl;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.appform.vo.UsuarioVO;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;
import co.com.jj.rastreapp.util.DateUtils;
import java.util.ArrayList;

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
    @Autowired
    PerfilIfaceDAO perfilIfaceDAO;
//    @Autowired
//    EmpresaIfaceDAO empresaIfaceDAO;
//    @Autowired
//    DireccionIfaceDAO direccionIfaceDAO;

    private static final DateUtils DATE_UTILS = DateUtils.getInstance();

    @Override
    public int registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        UsuarioVO usuarioVO = new UsuarioVO();
        CopyClassIface<UsuarioDTO, UsuarioVO> copy = new CopyClassImpl<>();
        usuarioVO = copy.copyDataClassToClass(usuarioDTO, usuarioVO);
        System.out.println("");
        return 0;
    }

    @Override
    public int actualizarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDTO getUserActivo(String nombreUsuario, String contrasena) throws Exception {
        List<UsuarioVO> lisUsuarioVOs = usuarioIfaceDAO.findByNombreUsuarioContrasena(nombreUsuario, contrasena);
        if (lisUsuarioVOs != null && !lisUsuarioVOs.isEmpty()) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            CopyClassIface<UsuarioVO, UsuarioDTO> copy = new CopyClassImpl<>();
            usuarioDTO = copy.copyDataClassToClass(lisUsuarioVOs.get(0), usuarioDTO);
            usuarioDTO.setContrasena("");
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
        List<UsuarioVO> lisUsuarioVOs = usuarioIfaceDAO.findByNombreUsuarioContrasena(nombreUsuario, "julio16");
        List<UsuarioDTO> list = new ArrayList<>();
        if (lisUsuarioVOs != null && !lisUsuarioVOs.isEmpty()) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            CopyClassIface<UsuarioVO, UsuarioDTO> copy = new CopyClassImpl<>();
            usuarioDTO = copy.copyDataClassToClass(lisUsuarioVOs.get(0), usuarioDTO);
            usuarioDTO.setContrasena("");
            list.add(usuarioDTO);
            return list;
        }
        return null;
    }

}
