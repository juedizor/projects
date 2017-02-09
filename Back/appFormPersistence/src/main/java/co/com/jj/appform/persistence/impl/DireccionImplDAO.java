/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.persistence.daofactory.CreateInstance;
import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
import co.com.jj.appform.persistence.iface.generics.DataAccessGenericIface;
import co.com.jj.appform.persistence.impl.generics.FactoryDataAccesGenerics;
import co.com.jj.appform.vo.DireccionVO;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author julio.izquierdo
 */
public class DireccionImplDAO implements DireccionIfaceDAO {

    private final DataAccessGenericIface DATA_ACCESS_GENERIC_IFACE;

    public DireccionImplDAO() throws Exception {
        CreateInstance<DataAccessGenericIface> instace = new CreateInstance<>();
        DATA_ACCESS_GENERIC_IFACE = instace.newInstance(FactoryDataAccesGenerics.getInstance());
    }

    @Override
    public DireccionVO findDireccion(DireccionVO direccionVO) throws Exception {
        String sql = "SELECT * FROM direccion WHERE codigo_tipo_documento = ? AND "
                + "numero_documento = ? AND "
                + "fecha_registro >= "
                + "(SELECT MAX(fecha_registro) "
                + "FROM direccion WHERE codigo_tipo_documento = ? AND numero_documento = ?)";
        Object[] params = {direccionVO.getCodigoTipoDocumento(),
            direccionVO.getNumeroDocumento(),
            direccionVO.getCodigoTipoDocumento(),
            direccionVO.getNumeroDocumento()};
        return DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<DireccionVO>(), params);
    }

    @Override
    public void save(DireccionVO object) throws Exception {
        String sql = "INSERT INTO direccion (nombre_direccion, "
                + "codigo_tipo_documento, "
                + "numero_documento, "
                + "fecha_registro) "
                + "VALUES (?, ?, ?, ?)";
        Object[] params = {
            object.getNombreDireccion(),
            object.getCodigoTipoDocumento(),
            object.getNumeroDocumento(),
            object.getFechaRegistro()
        };
        DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().update(sql, params);
    }

    @Override
    public void merge(DireccionVO object, DireccionVO objectAct) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DireccionVO> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DireccionVO> findByPrimaryKey(DireccionVO object) throws Exception {
        String sql = "SELECT * FROM direccion WHERE codigo_direccion = ?";
        return DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<DireccionVO>(), object.getCodigoDireccion());
    }

}
