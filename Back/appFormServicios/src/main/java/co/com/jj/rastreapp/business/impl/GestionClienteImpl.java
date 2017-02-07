/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.Ciudad;
import co.com.jj.appform.entity.Cliente;
import co.com.jj.appform.entity.Direccion;
import co.com.jj.appform.entity.Empresa;
import co.com.jj.appform.entity.Persona;
import co.com.jj.appform.entity.TipoDocumento;
import co.com.jj.appform.persistence.iface.ClienteIfaceDAO;
import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionClientesIface;
import co.com.jj.rastreapp.dto.ClienteDTO;
import co.com.jj.rastreapp.dto.DireccionDTO;
import co.com.jj.rastreapp.dto.EmpresaDTO;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.util.DateUtils;
import co.com.jj.rastreapp.util.EntityUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

                TipoDocumento tipoDocumento = ENTITY_UTILS.getTipoDocumento(clienteDTO.getPersona().getTipoDocumento());
                Ciudad ciudad = ENTITY_UTILS.getCiudad(clienteDTO.getPersona().getCiudad());
                Persona persona = ENTITY_UTILS.getPersona(clienteDTO.getPersona());
                persona.setIdCiudad(ciudad);
                persona.setIdTipoDocumento(tipoDocumento);
                persona.setFechaRegistro(fechaReg);
                cliente.setIdPersona(persona);
                Empresa empresa = ENTITY_UTILS.getEmpresa(clienteDTO.getEmpresa());
                cliente.setIdEmpresa(empresa);
                clienteIfaceDAO.save(cliente);
                Empresa newEmpresa = ENTITY_UTILS.getEmpresa(clienteDTO.getPersona().getEmpresa());
                newEmpresa.setIdPersona(cliente.getIdPersona());
                cliente.getIdPersona().setEmpresaList(Arrays.asList(newEmpresa));
                Direccion direccion = ENTITY_UTILS.getDireccion(clienteDTO.getPersona().getDireccion());
                direccion.setFechaInicial(fechaReg);
                direccion.setIdPersona(cliente.getIdPersona());
                cliente.getIdPersona().setDireccionList(Arrays.asList(direccion));
                persistenceApp.getEntityTransaction().commit();
            } catch (Exception e) {
                persistenceApp.getEntityTransaction().rollback();
                throw new Exception("Error realizando el registro del cliente:\n" + e.getMessage());

            }

        }

        return Respuestas.ERROR;
    }

    @Override
    public int actualizarCliente(ClienteDTO clienteDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteDTO> buscarClientesPorEmpresa(int idEmpresa) throws Exception {
        persistenceApp = new PersistenceApp();
        clienteIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
        List<Cliente> listClientes = clienteIfaceDAO.findByIdEmpresa(idEmpresa);
        List<ClienteDTO> listClienteDTO = new ArrayList<>();
        if (listClientes != null && !listClientes.isEmpty()) {
            for (Cliente cliente : listClientes) {
                ClienteDTO clienteDTO = new ClienteDTO();
                EmpresaDTO empresaDTO = ENTITY_UTILS.getEmpresaDTO(cliente.getIdPersona().getEmpresaList().get(0));
                PersonaDTO personaDTO = ENTITY_UTILS.getPersonaDTO(cliente.getIdPersona());
                DireccionDTO direccionDTO = ENTITY_UTILS.getDireccionDTO(cliente.getIdPersona().getDireccionList().get(cliente.getIdPersona().getDireccionList().size() - 1));
                TipoDocumentoDTO tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(cliente.getIdPersona().getIdTipoDocumento());
                personaDTO.setDireccion(direccionDTO);
                personaDTO.setTipoDocumento(tipoDocumentoDTO);
                personaDTO.setEmpresa(empresaDTO);
                clienteDTO.setIdCliente(cliente.getIdCliente());
                clienteDTO.setPersona(personaDTO);
                listClienteDTO.add(clienteDTO);
            }
        }
        return listClienteDTO;
    }

}
