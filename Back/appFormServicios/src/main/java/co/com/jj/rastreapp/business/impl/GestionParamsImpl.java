/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.entity.Perfil;
import co.com.jj.appform.entity.TipoDocumento;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.rastreapp.business.iface.GestionParamsIface;
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.util.EntityUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julio.izquierdo
 */
@Service
public class GestionParamsImpl implements GestionParamsIface {

    @Autowired
    TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
    @Autowired
    PerfilIfaceDAO perfilIfaceDAO;

    private static final EntityUtils ENTITY_UTILS = EntityUtils.getInstance();

    @Override
    public List<TipoDocumentoDTO> obtenerTiposDocumentos() throws Exception {
        List<TipoDocumento> listTipoDocumento = tipoDocumentoIfaceDAO.findAll();
        TipoDocumentoDTO tipoDocumentoDTO;
        List<TipoDocumentoDTO> listTipoDocumentoDTO = new ArrayList<>();
        if (listTipoDocumento != null && !listTipoDocumento.isEmpty()) {
            for (TipoDocumento tipoDocumento : listTipoDocumento) {
                tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(tipoDocumento);
                listTipoDocumentoDTO.add(tipoDocumentoDTO);
            }
        }

        return listTipoDocumentoDTO;
    }

    @Override
    public List<PerfilDTO> obtenerPerfiles() throws Exception {
        List<Perfil> listPerfil = perfilIfaceDAO.findAll();
        PerfilDTO perfilDTO;
        List<PerfilDTO> listPerfilDTO = new ArrayList<>();
        if (listPerfil != null && !listPerfil.isEmpty()) {
            for (Perfil perfil : listPerfil) {
                perfilDTO = ENTITY_UTILS.getPerfilDTO(perfil);
                listPerfilDTO.add(perfilDTO);
            }
        }

        return listPerfilDTO;
    }

}
