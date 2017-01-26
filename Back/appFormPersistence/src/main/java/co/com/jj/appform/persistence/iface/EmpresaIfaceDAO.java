/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Empresa;
import javax.persistence.EntityManager;

/**
 *
 * @author julio.izquierdo
 */
public interface EmpresaIfaceDAO {

    void save(Empresa empresa);

    void merge(Empresa empresa);

    Empresa findByIdPersona(int idPersona) throws Exception;

    void setEntityManager(EntityManager manager) throws Exception;

}
