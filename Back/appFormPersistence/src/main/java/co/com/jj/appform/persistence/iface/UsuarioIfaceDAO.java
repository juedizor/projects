/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.persistence.iface.generics.PersistenciaIfaceDAO;
import co.com.jj.appform.vo.UsuarioVO;
import java.util.List;

/**
 *
 * @author jeio
 */
public interface UsuarioIfaceDAO extends PersistenciaIfaceDAO<UsuarioVO, UsuarioVO>{

    public UsuarioVO findByNombreUsuario(String nombreUsuario) throws Exception;

    public List<UsuarioVO> findByNombreUsuarioContrasena(String nombreUsuario, String contrasena) throws Exception;
    
    List<UsuarioVO> findByEmpresaAndNotNombreUsuario(int idEmpresa, String nombreUsuario) throws Exception;
    

}
