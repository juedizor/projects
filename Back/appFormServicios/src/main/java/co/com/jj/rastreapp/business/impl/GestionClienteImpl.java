/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.Cliente;
import co.com.jj.appform.entity.Direccion;
import co.com.jj.appform.entity.Empresa;
import co.com.jj.appform.entity.Persona;
import co.com.jj.appform.persistence.iface.ClienteIfaceDAO;
import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionClientesIface;
import co.com.jj.rastreapp.dto.ClienteDTO;
import co.com.jj.rastreapp.util.DateUtils;
import co.com.jj.rastreapp.util.EntityUtils;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeio
 */
@Service
public class GestionClienteImpl implements GestionClientesIface {

    @Autowired
    UsuarioIfaceDAO usuarioIfaceDAO;
    @Autowired
    PersonaIfaceDAO personaIfaceDAO;
    @Autowired
    TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
    @Autowired
    PerfilIfaceDAO perfilIfaceDAO;
    @Autowired
    DireccionIfaceDAO direccionIfaceDAO;
    @Autowired
    ClienteIfaceDAO clienteIfaceDAO;

    private static final DateUtils DATE_UTILS = DateUtils.getInstance();
    private static final EntityUtils ENTITY_UTILS = EntityUtils.getInstance();
    private PersistenceApp persistenceApp;

    @Override
    public int registrarCliente(ClienteDTO clienteDTO) throws Exception {
        if (clienteDTO != null) {
            persistenceApp = new PersistenceApp();
            try {
                java.sql.Timestamp fechaReg = DATE_UTILS.getFechaActual(); // fecha Actual
                persistenceApp.getEntityTransaction().begin();
                /**
                 * inicializa los DAO para acceso a CRUD
                 */
                tipoDocumentoIfaceDAO.setEntityManager(persistenceApp.getManager());
                perfilIfaceDAO.setEntityManager(persistenceApp.getManager());
                usuarioIfaceDAO.setEntityManager(persistenceApp.getManager());
                personaIfaceDAO.setEntityManager(persistenceApp.getManager());
                direccionIfaceDAO.setEntityManager(persistenceApp.getManager());
                clienteIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
                
                Cliente cliente = new Cliente();
                
                Persona persona = ENTITY_UTILS.getPersona(clienteDTO.getPersona());
                persona.setFechaRegistro(fechaReg);
                cliente.setIdPersona(persona);
                Empresa empresa = ENTITY_UTILS.getEmpresa(clienteDTO.getEmpresa());
                cliente.setIdEmpresa(empresa);
                clienteIfaceDAO.save(cliente);
                Direccion direccion = ENTITY_UTILS.getDireccion(clienteDTO.getPersona().getDireccion());
                direccion.setFechaInicial(fechaReg);
                direccion.setIdPersona(cliente.getIdPersona());
                cliente.getIdPersona().setDireccionList(Arrays.asList(direccion));
                persistenceApp.getEntityTransaction().commit();
                

            } catch (Exception e) {
                persistenceApp.getEntityTransaction().rollback();

            }

        }

        return Respuestas.ERROR;
    }

    @Override
    public int actualizarCliente(ClienteDTO clienteDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
