/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Perfil;
import java.util.List;

/**
 *
 * @author jeio
 */
public interface PerfilIfaceDAO {
    
    public List<Perfil> findAll() throws Exception;
    public Perfil findByNombre(String nombre) throws Exception;
    
}