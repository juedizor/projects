/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.persistence.daofactory.CreateInstance;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.appform.persistence.iface.generics.DataAccessGenericIface;
import co.com.jj.appform.persistence.impl.generics.FactoryDataAccesGenerics;
import co.com.jj.appform.vo.UsuarioVO;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author jeio
 */
public class UsuarioImplDAO implements UsuarioIfaceDAO {

    private final DataAccessGenericIface DATA_ACCESS_GENERIC_IFACE;

    public UsuarioImplDAO() throws Exception {
        CreateInstance<DataAccessGenericIface> instace = new CreateInstance<>();
        DATA_ACCESS_GENERIC_IFACE = instace.newInstance(FactoryDataAccesGenerics.getInstance());
        
    }

    @Override
    public UsuarioVO findByNombreUsuario(String nombreUsuario) throws Exception {
        String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";
        List<UsuarioVO> listUsuarioVOs = DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(UsuarioVO.class),
                nombreUsuario);
        if (listUsuarioVOs != null && !listUsuarioVOs.isEmpty()) {
            return listUsuarioVOs.get(0);
        }
        return null;
    }

    @Override
    public List<UsuarioVO> findByNombreUsuarioContrasena(String nombreUsuario, String contrasena) throws Exception {
        String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contrasena = ?";
        List<UsuarioVO> listUsuarioVOs = DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(UsuarioVO.class),
                nombreUsuario, contrasena);
        return listUsuarioVOs;
    }

    /**
     * 
     * @param idEmpresa
     * @param nombreUsuario
     * @return
     * @throws Exception 
     */
    @Override
    public List<UsuarioVO> findByEmpresaAndNotNombreUsuario(int idEmpresa, String nombreUsuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(UsuarioVO object) throws Exception {
        String sql = "INSERT INTO usuario (codigo_perfil, "
                + "codigo_tipo_documento, "
                + "numero_documento, "
                + "nombre_usuario, "
                + "contrasena, "
                + "fecha_creacion, "
                + "activo, "
                + "fecha_modificacion) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {
            object.getCodigoPerfil(),
            object.getCodigoTipoDocumento(),
            object.getNumeroDocumento(),
            object.getNombreUsuario(),
            object.getContrasena(),
            object.getFechaCreacion(),
            object.isActivo(),
            object.getFechaModificacion()
        };
        DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().update(sql, params);

    }

    @Override
    public void merge(UsuarioVO object, UsuarioVO objectAct) throws Exception {
        String sql = "UPDATE usuario SET "
                + "codigo_perfil = ?, "
                + "codigo_tipo_documento = ?, "
                + "numero_documento = ?, "
                + "nombre_usuario = ?, "
                + "contrasena = ?, "
                + "activo = ?, "
                + "fecha_modificacion = ? "
                + "WHERE id_usuario = ?";
        Object[] params = {objectAct.getIdUsuario()};
        DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().update(sql, params);
    }

    @Override
    public List<UsuarioVO> findAll() throws Exception {
        String sql = "SELECT * FROM usuario";
        return DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UsuarioVO>());
    }

    @Override
    public List<UsuarioVO> findByPrimaryKey(UsuarioVO object) throws Exception {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        return DATA_ACCESS_GENERIC_IFACE.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UsuarioVO>(), object.getIdUsuario());
    }

}
