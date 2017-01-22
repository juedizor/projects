/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Direccion;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author julio.izquierdo
 */
public interface DireccionIfaceDAO {

    void save(Direccion direccion);

    void merge(Direccion direccion);

    Direccion findById(int idDireccion) throws Exception;

    Direccion findByIdPersona(int idPersona) throws Exception;

    void setEntityManager(EntityManager manager);

}
