/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeio
 */
public interface UsuarioIfaceDAO {

    public void save(Usuario usuario) throws Exception;

    public void merge(Usuario usuario) throws Exception;

    List<Usuario> findAll() throws Exception;
    
    public Usuario findById(int id) throws Exception;

    public Usuario findByNombreUsuario(String nombreUsuario) throws Exception;

    public List<Usuario> findByNombreUsuarioContrasenaActivo(String nombreUsuario, String contrasena, boolean activo) throws Exception;

    public void setEntityManager(EntityManager manager) throws Exception;

}
