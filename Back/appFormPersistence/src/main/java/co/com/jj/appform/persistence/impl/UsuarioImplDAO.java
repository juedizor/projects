/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.appform.vo.UsuarioVO;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author jeio
 */
public class UsuarioImplDAO extends DataAccesGenericImpl implements UsuarioIfaceDAO {

    public UsuarioImplDAO() throws Exception {
        super();
    }

    @Override
    public UsuarioVO findByNombreUsuario(String nombreUsuario) throws Exception {
        sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";
        List<UsuarioVO> listUsuarioVOs = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(UsuarioVO.class), nombreUsuario);
        if (listUsuarioVOs != null && !listUsuarioVOs.isEmpty()) {
            return listUsuarioVOs.get(0);
        }
        return null;
    }

    @Override
    public List<UsuarioVO> findByNombreUsuarioContrasena(String nombreUsuario, String contrasena) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioVO> findByEmpresaAndNotNombreUsuario(int idEmpresa, String nombreUsuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(UsuarioVO object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void merge(UsuarioVO object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioVO> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioVO> findById(UsuarioVO object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
