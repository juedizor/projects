/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform;

import co.com.jj.appform.persistence.daofactory.CreateInstance;
import co.com.jj.appform.persistence.daofactory.FactoryUsuarioDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;

/**
 *
 * @author jeio
 */
public class Test {
    
    public static void main(String[] args) throws Exception {
        UsuarioIfaceDAO usuarioIfaceDAO = (UsuarioIfaceDAO) CreateInstance.getInstance().newInstance(FactoryUsuarioDAO.getInstance());
        usuarioIfaceDAO.findByNombreUsuario("juedizor");
    }
    
}
