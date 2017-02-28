/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.persistence.daofactory.CreateInstance;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.generics.DataAccessGenericIface;
import co.com.jj.appform.persistence.impl.generics.FactoryDataAccesGenerics;
import co.com.jj.appform.vo.PersonaVO;
import java.util.List;

/**
 *
 * @author jeio
 */
public class PersonaImplDAO implements PersonaIfaceDAO {

    
    private final DataAccessGenericIface DATA_ACCESS_GENERIC_IFACE;
    
    public PersonaImplDAO() throws Exception {
        CreateInstance<DataAccessGenericIface> instace = new CreateInstance<>();
        DATA_ACCESS_GENERIC_IFACE = instace.newInstance(FactoryDataAccesGenerics.getInstance());
    }
    
    @Override
    public PersonaVO findByTipoDocumentoNumeroDocumento(int tipoDocumento, Long numeroDocumento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonaVO findByEmail(String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(PersonaVO object) throws Exception {
        String sql = "INSERT INTO persona (codigo_tipo_documento, "
                + "numero_documento, "
                + "nombre1, "
                + "nombre2, "
                + "apellido1, "
                + "apellido2, "
                + "fecha_registro, "
                + "fecha_modificacion, "
                + "email, "
                + "codigo_ciudad) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object [] params = {
            object.getCodigoTipoDocumento(), 
            object.getNumeroDocumento(), 
            object.getNombre1(), 
            object.getNombre2(), 
            object.getApellido1(), 
            object.getApellido2(), 
            object.getFechaRegistro(), 
            object.getFechaModificacion(), 
            object.getEmail(), 
            object.getCodigoCiudad()
        };
        DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().update(sql, params);
    }

    @Override
    public void merge(PersonaVO object, PersonaVO objectAct) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaVO> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaVO> findByPrimaryKey(PersonaVO object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}
