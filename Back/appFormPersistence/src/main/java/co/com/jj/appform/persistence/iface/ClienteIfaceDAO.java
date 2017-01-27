/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author jeio
 */
public interface ClienteIfaceDAO {

    void save(Cliente cliente) throws Exception;

    void merge(Cliente cliente) throws Exception;

    void setEntityManager(EntityManager manager) throws Exception;

}
