/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.Usuario;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jeio
 */
public class UsuarioImplDAO implements UsuarioIfaceDAO {

    private EntityManager manager;

    @Override
    public void save(Usuario usuario) throws Exception {
        manager.persist(usuario);
    }

    @Override
    public void merge(Usuario usuario) throws Exception {
        manager.merge(usuario);
    }

    @Override
    public Usuario findByNombreUsuario(String nombreUsuario) throws Exception {
        List<Usuario> listAeUsuarios = manager.createNamedQuery("Usuario.findByNombreUsuario")
                .setParameter("nombreUsuario", nombreUsuario)
                .getResultList();
        if (listAeUsuarios != null && !listAeUsuarios.isEmpty()) {
            return listAeUsuarios.get(0);
        }
        return null;
    }

    @Override
    public List<Usuario> findByNombreUsuarioContrasenaActivo(String nombreUsuario, String contrasena, boolean activo) throws Exception {
        Query query = manager.createNamedQuery("Usuario.findByNombreUsuarioContrasenaActivo");
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("contrasena", contrasena);
        query.setParameter("activo", activo);
        return query.getResultList();
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        return manager.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public void setEntityManager(EntityManager manager) {
        this.manager = manager;
    }

}
