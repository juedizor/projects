/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.MainApp;
import co.com.jj.appform.entity.Usuario;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author jeio
 */
public class UsuarioImplDAO implements UsuarioIfaceDAO {

    
    private final MainApp mainApp = MainApp.getInstance();

    @Override
    public void save(Usuario usuario) throws Exception {
        mainApp.getEntityManager().persist(usuario);
    }

    @Override
    public void merge(Usuario usuario) throws Exception {
        mainApp.getEntityManager().merge(usuario);
    }

    @Override
    public Usuario findByNombreUsuario(String nombreUsuario) throws Exception {
        List<Usuario> listAeUsuarios = mainApp.getEntityManager().createNamedQuery("Usuario.findByNombreUsuario")
                .setParameter("nombreUsuario", nombreUsuario)
                .getResultList();
        if (listAeUsuarios != null && !listAeUsuarios.isEmpty()) {
            return listAeUsuarios.get(0);
        }
        return null;
    }

    @Override
    public List<Usuario> findByNombreUsuarioActivo(String nombreUsuario, boolean activo) throws Exception {
        Query query = mainApp.getEntityManager().createNamedQuery("Usuario.findByNombreUsuarioActivo");
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("activo", activo);
        return query.getResultList();
    }

}