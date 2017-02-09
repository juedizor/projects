/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.persistence.daofactory.CreateInstance;
import co.com.jj.appform.persistence.iface.EmpresaIfaceDAO;
import co.com.jj.appform.persistence.iface.generics.DataAccessGenericIface;
import co.com.jj.appform.persistence.impl.generics.FactoryDataAccesGenerics;
import co.com.jj.appform.vo.EmpresaVO;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author julio.izquierdo
 */
public class EmpresaImplDAO implements EmpresaIfaceDAO {

    private final DataAccessGenericIface DATA_ACCESS_GENERIC_IFACE;

    public EmpresaImplDAO() throws Exception {
        CreateInstance<DataAccessGenericIface> instace = new CreateInstance<>();
        DATA_ACCESS_GENERIC_IFACE = instace.newInstance(FactoryDataAccesGenerics.getInstance());
    }

    @Override
    public void save(EmpresaVO object) throws Exception {
        String sql = "INSERT INTO empresa (codigo_tipo_documento, "
                + "numero_documento, "
                + "nombre_empresa, "
                + "descripcion_empresa, "
                + "fecha_registro, "
                + "fecha_modificacion) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        Object[] params = {
            object.getCodigoTipoDocumento(),
            object.getNumeroDocumento(),
            object.getNombreEmpresa(),
            object.getDescripcionEmpresa(),
            object.getFechaRegistro(),
            object.getFechaModificacion()
        };
        DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().update(sql, params);
    }

    @Override
    public void merge(EmpresaVO object, EmpresaVO objectAct) throws Exception {
        String sql = "UPDATE empresa SET "
                + "codigo_tipo_documento = ?, "
                + "numero_documento = ?, "
                + "nombre_empresa = ?, "
                + "descripcion_empresa = ?, "
                + "fecha_modificacion = ? "
                + "WHERE codigo_tipo_documento = ? AND numero_documento = ?";
        Object[] params = {objectAct.getCodigoTipoDocumento(),
            objectAct.getNumeroDocumento()};
        DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().update(sql, params);

    }

    @Override
    public List<EmpresaVO> findAll() throws Exception {
        String sql = "SELECT * FROM empresa";
        return DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<EmpresaVO>());
    }

    @Override
    public List<EmpresaVO> findByPrimaryKey(EmpresaVO object) throws Exception {
        String sql = "SELECT * FROM empresa WHERE codigo_tipo_documento = ? "
                + "AND numero_documento = ?";
        return DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper<EmpresaVO>(),
                object.getCodigoTipoDocumento(),
                object.getNumeroDocumento());
    }

}
